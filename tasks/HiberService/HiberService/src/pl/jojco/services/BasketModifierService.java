package pl.jojco.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.hibernate.SessionFactory;

import com.sun.jersey.spi.inject.Inject;

import pl.jojco.pojo.Basket;

@Path("/baket")
public class BasketModifierService {

	private SessionFactory factory;
	
	@POST
	@Path("/get")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Basket getBasket(int id){
		return null;
		
	}
	
	@POST
	@Path("/update")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public boolean  updateBaket(Basket basket){
		
		return true;
	}

	public SessionFactory getFactory() {
		return factory;
	}

	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}
}
