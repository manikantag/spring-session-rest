package com.manikanta;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/")
public class TestResource {

	@GET
	public Response hello() {
		return Response.ok("success").build();
	}
	
}
