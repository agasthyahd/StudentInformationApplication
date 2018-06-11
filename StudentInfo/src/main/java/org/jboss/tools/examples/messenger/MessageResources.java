package org.jboss.tools.examples.messenger;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;

import org.jboss.tools.examples.messenger.message.*;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import org.jboss.tools.examples.messenger.service.*;
@Path("/students")
public class MessageResources {

	
	Messageservice ms=new Messageservice();
	/*@POST
	public Response send(Message message)
	
	{
		
		Message m=ms.addMessage(message);
		return Response.status(Status.CREATED)		
					.entity(m)
					.build();
						
		
	}*/
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public  List<student> getMessages(@QueryParam("year") int year,@BeanParam MessageFilterBean filterbean)
	{
		if(year>0)
			return ms.getAllMessageForYear(filterbean.getYear());
		
		if(filterbean.getStart() >=0 &&filterbean.getSize()>0)
			return ms.getAllMessagePaginated(filterbean.getStart(),filterbean.getSize());
		return ms.getAllMessages();
	} 
	
	
	
	
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)

	public student updateMessage(@PathParam("studentId") long id,student student)
	
	{
		
		student.setId(id);
		return ms.updateMessage(student);
	}
	
	@DELETE
	@Path("/{studentId}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void deleteMessage(@PathParam("studentId")long id)
	{
		ms.removeMessage(id);
		
		
	}
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public student addMessage(student student)
	{
		
		return ms.addMessage(new student(student.getId(),student.getName(),student.getRollno()));
	}
	
	@GET
	@Path("/{studentId}")
	@Produces(MediaType.APPLICATION_JSON)
	public student getMessage(@PathParam("studentId") long id)
	
	{
		
		
		return ms.getMessage(id);
	}
	
	@Path("/{studentId}/remarks")
	public RemarksResource getCommentResource() {
		return new RemarksResource();
	}
	

	

	
	
	
}
