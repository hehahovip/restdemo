/**
 * 
 */
package com.hehaho.restdemo.resources;

import java.util.UUID;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;

import com.google.gson.Gson;
import com.hehaho.restdemo.beans.Person;
import com.hehaho.restdemo.beans.Puppy;
import com.hehaho.restdemo.services.DemoService;


/**
 * @author Kevin
 *
 */
@Path("/demo")
public class DemoResource {

	@Autowired
	private DemoService demoService;
	
	public DemoResource() {
		super();
		System.out.println("DemoResource init...");
	}

	@GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getHello() {
        return demoService.sayHello("Kevin");
    }
	
	@GET
	@Path("/hello")
    @Produces(MediaType.TEXT_PLAIN)
    public String getHelloText() {
        return "Hello World!";
    }
	
	@POST
	@Path("/person")
	@Produces(MediaType.APPLICATION_JSON)
	public Response createPerson(String pString){
		
		Gson g = new Gson();
		Person p = null;
		p = g.fromJson(pString, Person.class);
		p.setId(UUID.randomUUID().toString());
		System.out.println(p.getName());
		
		Puppy p1 = new Puppy();
		p1.setId(UUID.randomUUID().toString());
		p1.setName("adf");
		p1.setPerson(p);
		
		Puppy p2 = new Puppy();
		p2.setId(UUID.randomUUID().toString());
		p2.setName("ghd");
		p2.setPerson(p);
		
		p.getPuppies().add(p1);
		p.getPuppies().add(p2);
		
		demoService.addPerson(p);
		
		return Response.status(Status.CREATED).entity("gg").build();
	}

	public DemoService getDemoService() {
		return demoService;
	}

	
//	@Required
	public void setDemoService(DemoService demoService) {
		this.demoService = demoService;
	}
	
	
}
