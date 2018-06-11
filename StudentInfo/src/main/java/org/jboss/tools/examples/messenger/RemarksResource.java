package org.jboss.tools.examples.messenger;




import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.tools.examples.messenger.comment.service.Remarkservice;
import org.jboss.tools.examples.messenger.message.remarks;
import org.jboss.tools.examples.messenger.comment.service.*;




@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class RemarksResource {

	private static Remarkservice remarkService = new Remarkservice();
	
	@GET
	public ArrayList<remarks> getAllComments(@PathParam("studentId") long studentID) {
		return remarkService.getAllComments(studentID);
	}
	
	
	@POST
	
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)

	public remarks addRemark(@PathParam("studentId") long studentID, remarks remarks) {
		return remarkService.addRemark(studentID, remarks);
	}
	
	@PUT
	@Path("{commentId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)

	public remarks updateComment(@PathParam("studentId") long messageID, @PathParam("commentId") long id, remarks remarks) {
		remarks.setId(id);
		return remarkService.updateRemark(messageID, remarks);
	}
	
	@DELETE
	@Path("{commentId}")
	@Consumes(MediaType.APPLICATION_JSON)

	public void deleteComment(@PathParam("studentId") long messageID, @PathParam("commentId") long commentId) {
		remarkService.removeComment(messageID, commentId);
	}
	
	
	@GET
	@Path("{commentId}")
	@Produces(MediaType.APPLICATION_JSON)
	

	public remarks getMessage(@PathParam("studentId") long messageID, @PathParam("commentId") long commentId) {
		return remarkService.getRemark(messageID, commentId);
	}
	
}



