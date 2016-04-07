package com.manikanta;

import java.util.Arrays;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("apps")
public class AppsResource {

	@GET
	public Response getAllApps() {
		return Response.ok(Arrays.asList("app1", "app2", "app3")).build();
	}
	
}
