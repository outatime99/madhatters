/**
 * 
 */
package com.investec.expd.rest;

import java.util.ArrayList;
import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import com.investec.expd.model.User;


/**
 * @author gregf
 *
 * This class is really just the endpoint of the rest service.
 * It should inject the EJB service and simply invoke its methods
 * 
 * TODO: Must still add a POST method (Probably for the create and delete
 */

@Stateless
@Path("/users")
public class UserServiceEndpoint {

	//@EJB 
	//private WidgetService widgetService;
	
	final static Logger logger = Logger.getLogger(UserServiceEndpoint.class);
	
    @GET
    @Path("/count")
    @Produces(MediaType.APPLICATION_JSON)
	public Response getCount() {
    	logger.debug("Rest Invoked. Method: getCount()");
    	long count = 0;
    	String responseMsg = null;
    	
		try {
	    	//DUMMY DATA START
	    	count = 12;
	    	// DUMY DATA END
			//count = widgetService.getCount();
		} catch (Exception e) {
			e.printStackTrace();
			responseMsg = e.getMessage();
			return Response.serverError().entity(responseMsg).build();
		} 
  
		return Response.ok(count, MediaType.APPLICATION_JSON).build();		
	}	
	
    @GET
    @Produces(MediaType.APPLICATION_JSON)
	public Response getAllUsers() {

    	logger.debug("Rest Invoked. Method: getAllUsers()");
    	ArrayList<User> userList = null;
    	
    	String responseMsg = null;
    	
		try {
			//DUMMY DATA START
			userList = new ArrayList<User>();
			User dummyUser = new User();
			dummyUser.setUserName("TestUSer");
			dummyUser.setUserSurname("TestSurname");
			userList.add(dummyUser);
			//DUMMY DATA END
			//userList = widgetService.getAllWidgets();
		} catch (Exception e) {
			e.printStackTrace();
			responseMsg = e.getMessage();
			return Response.serverError().entity(responseMsg).build();
		}   
    	
		if (userList == null) {
	           return Response.status(Response.Status.NOT_FOUND).entity("No users are available").build();
		}
     
		return Response.ok(userList, MediaType.APPLICATION_JSON).build(); 
	}
    
    
    @GET
    @Path("/{user_id}")
    @Produces(MediaType.APPLICATION_JSON)
	public Response getUser(@PathParam("user_id") int userId) {
    	
        logger.debug("Rest Invoked. Method: getUser(int userId)");
 	
        String responseMsg = null;
        	
        if(userId == 0) {
            return Response.serverError().entity("User Id cannot be 0").build();
        }
        
        User user = null;
        
		try {
			//DUMMY DATA START
			User dummyUser = new User();
			dummyUser.setUserName("TestUSer");
			dummyUser.setUserSurname("TestSurname");
			user = dummyUser;
			// DUMMY DATA END
			//widget = widgetService.getWidget(widgetId);
		} catch (Exception e) {
			e.printStackTrace();
			responseMsg = e.getMessage();
			return Response.serverError().entity(responseMsg).build();
		}   
		
		if (user == null) {
			return Response.status(Response.Status.NOT_FOUND).entity("No user found for user id: " + userId).build();	
	    }
        
        return Response.ok(user, MediaType.APPLICATION_JSON).build();
	}    
    
    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createUser(User user){
    	logger.debug("Rest Invoked. Method: createUser()");
    	System.out.println("Rest Invoked. Method: createUser()");

        String responseMsg = null;
    	
        // TODO: Detailed checks should be done with BeanValidation
        if (user == null) {
        	return Response.serverError().entity("User cannot be null").build();
        } else if(user.getUserId() > 0) {
            return Response.serverError().entity("User Id cannot be supplied when creating a user. Please exclude it or specify an id of 0").build();
        }
        
		try {
			//DUMMY DATA START
			User dummyUser = new User();
			dummyUser.setUserName("TestUSer");
			dummyUser.setUserSurname("TestSurname");
			user = dummyUser;
			// DUMMY DATA END
			//user = widgetService.createWidget(widget);
		} catch (Exception e) {
			e.printStackTrace();
			responseMsg = e.getMessage();
			return Response.serverError().entity(responseMsg).build();
		}   
		
		if (user == null) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Could not create user").build();	
	    }
        
        return Response.ok(user, MediaType.APPLICATION_JSON).build();
	}
    
    /*
    @POST
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateWidget(Widget widget){
    	logger.debug("Rest Invoked. Method: updateWidget()");

        String responseMsg = null;
    	
        if (widget == null) {
        	return Response.serverError().entity("Widget cannot be null").build();
        } else if(widget.getWidgetId() == 0) {
            return Response.serverError().entity("Widget Id cannot be blank").build();
        }
               
		try {
			widget = widgetService.updateWidget(widget);
		} catch (Exception e) {
			e.printStackTrace();
			responseMsg = e.getMessage();
			return Response.serverError().entity(responseMsg).build();
		}   
		
		if (widget == null) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Could not update widget").build();	
	    }
        
        return Response.ok(widget, MediaType.APPLICATION_JSON).build();
	}  
 
    @POST
    @Path("/delete")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteWidget(Widget widget){
    	logger.debug("Rest Invoked. Method: deleteWidget()");

        String responseMsg = null;
    	
        if (widget == null) {
        	return Response.serverError().entity("Widget cannot be null").build();
        } else if(widget.getWidgetId() == 0) {
            return Response.serverError().entity("Widget Id cannot be blank").build();
        }
               
		try {
			widgetService.deleteWidget(widget);
		} catch (Exception e) {
			e.printStackTrace();
			responseMsg = e.getMessage();
			return Response.serverError().entity(responseMsg).build();
		}   
        
        return Response.ok().build();
	}  */
    
}
