package com.manikanta;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

@Path("auth")
public class LoginResource {

	@GET
	public Response login(@QueryParam("un") String username, @QueryParam("pw") String password, @Context HttpServletRequest request) {
		if("test".equals(username) && "test".equals(password)) {
			System.out.println("Login success");
			request.getSession().setAttribute("permissions", "aaa");
			return Response.ok().build();
		} else {
			System.out.println("Login failed");
			return Response.status(401).build();
		}
	}
	
}
