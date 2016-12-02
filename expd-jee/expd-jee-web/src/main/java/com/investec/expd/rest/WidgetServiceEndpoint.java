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

import com.investec.expd.ejb.WidgetService;
import com.investec.expd.model.Widget;

/**
 * @author gregf
 *
 * This class is really just the endpoint of the rest service.
 * It should inject the EJB service and simply invoke its methods
 * 
 * TODO: Must still add a POST method (Probably for the create and delete
 */

@Stateless
@Path("/widgets")
public class WidgetServiceEndpoint {

	@EJB 
	private WidgetService widgetService;
	
	final static Logger logger = Logger.getLogger(WidgetServiceEndpoint.class);
	
    @GET
    @Path("/count")
    @Produces(MediaType.APPLICATION_JSON)
	public Response getCount() {
    	logger.debug("Rest Invoked. Method: getCount()");
    	long count = 0;
    	String responseMsg = null;
    	
		try {
			count = widgetService.getCount();
		} catch (Exception e) {
			e.printStackTrace();
			responseMsg = e.getMessage();
			return Response.serverError().entity(responseMsg).build();
		} 
  
		return Response.ok(count, MediaType.APPLICATION_JSON).build();		
	}	
	
    @GET
    @Produces(MediaType.APPLICATION_JSON)
	public Response getAllWidgets() {

    	logger.debug("Rest Invoked. Method: getAllWidgets()");
    	ArrayList<Widget> widgetList = null;
    	String responseMsg = null;
    	
		try {
			widgetList = widgetService.getAllWidgets();
		} catch (Exception e) {
			e.printStackTrace();
			responseMsg = e.getMessage();
			return Response.serverError().entity(responseMsg).build();
		}   
    	
		if (widgetList == null) {
	           return Response.status(Response.Status.NOT_FOUND).entity("No widgets are available").build();
		}
     
		return Response.ok(widgetList, MediaType.APPLICATION_JSON).build(); 
	}
    
    @GET
    @Path("/{widget_id}")
    @Produces(MediaType.APPLICATION_JSON)
	public Response getWidget(@PathParam("widget_id") int widgetId) {
    	
        logger.debug("Rest Invoked. Method: getWidget(int widgetId)");
 	
        String responseMsg = null;
        	
        if(widgetId == 0) {
            return Response.serverError().entity("Widget Id cannot 0").build();
        }
        
        Widget widget = null;
        
		try {
			widget = widgetService.getWidget(widgetId);
		} catch (Exception e) {
			e.printStackTrace();
			responseMsg = e.getMessage();
			return Response.serverError().entity(responseMsg).build();
		}   
		
		if (widget == null) {
			return Response.status(Response.Status.NOT_FOUND).entity("No widget found for widget id: " + widgetId).build();	
	    }
        
        return Response.ok(widget, MediaType.APPLICATION_JSON).build();
	}    
    
    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createWidget(Widget widget){
    	logger.debug("Rest Invoked. Method: createWidget()");

        String responseMsg = null;
    	
        // TODO: Detailed checks should be done with BeanValidation
        if (widget == null) {
        	return Response.serverError().entity("Widget cannot be null").build();
        } else if(widget.getWidgetId() > 0) {
            return Response.serverError().entity("Widget Id cannot be supplied when creating a widget. Please exclude it or specify an id of 0").build();
        }
        
		try {
			widget = widgetService.createWidget(widget);
		} catch (Exception e) {
			e.printStackTrace();
			responseMsg = e.getMessage();
			return Response.serverError().entity(responseMsg).build();
		}   
		
		if (widget == null) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Could not create widget").build();	
	    }
        
        return Response.ok(widget, MediaType.APPLICATION_JSON).build();
	}
    
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
	}  
    
}
