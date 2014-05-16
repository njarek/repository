package pl.jojco;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import org.eclipse.jdt.internal.compiler.codegen.IntegerCache;
 
@Path("/hello")
public class HelloWorldService {
 
	@GET
	@Path("/{param}")
	public Response getMsg(@PathParam("param") String msg) {
 
		int suma=Integer.parseInt(msg)+20;
		
		String output = "Jersey say : " + suma;
 
		return Response.status(200).entity(output).build();
 
	}
 
}