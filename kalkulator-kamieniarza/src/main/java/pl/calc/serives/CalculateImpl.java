package pl.calc.serives;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import pl.calc.business.CalculateTombstone;
import pl.calc.business.CalculateTombstoneImpl;
import pl.calc.domain.TombstoneClient;
import pl.calc.domain.TombstoneResult;

@Path("/calculate")
public class CalculateImpl implements Calculate {

	@POST
	@Path("/tombstone")
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public TombstoneResult calculate(TombstoneClient tombstoneClient) {
		System.out.println(tombstoneClient);
		CalculateTombstone calculateTombstone = new CalculateTombstoneImpl();
		TombstoneResult result = calculateTombstone.calculateTombstone(tombstoneClient);
		return result;
	}

}
