package org.jboss.tools.examples.messenger;

import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.UriInfo;

@Path("/injectdemo")

public class InjectDemoResource {

	@GET
	@Path("annotations")
	 public String inject(@MatrixParam("param") String matrixparam,@HeaderParam("customerParamValue")String header,
			 @CookieParam("cookie") String cookie)
	{return "Matrix param:"+matrixparam+"Header Param "+header+"Cookie Param"+cookie;}

	@GET
	@Path("context")
	public String getParams(@Context UriInfo UriInfo,@Context HttpHeaders headers)

	{
		
		String path=UriInfo.getAbsolutePath().toString();
		String cookies=headers.getCookies().toString();
		return "Path "+path+"Cookie "+cookies;
	}





}
