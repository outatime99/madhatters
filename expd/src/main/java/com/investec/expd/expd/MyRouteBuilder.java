package com.investec.expd.expd;

import org.apache.camel.Message;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;

/**
 * A Camel Java8 DSL Router
 */
public class MyRouteBuilder extends RouteBuilder {

    /**
     * Let's configure the Camel routing rules using Java code...
     */
    public void configure() {

    restConfiguration().component("jetty")
    	.bindingMode(RestBindingMode.json)
    	.dataFormatProperty("prettyPrint", "true")
    	.enableCORS(true)
    	.port(8080);
    	
    
    
    rest("/dashboard")
        .get("/mytaskscount").consumes("application/json").to("direct:mytaskscount")
        .get("/alltaskscount").consumes("application/json").to("direct:alltaskscount")
        .get("/myideascount").consumes("application/json").to("direct:myideascount")
        .get("/allideascount").consumes("application/json").to("direct:allideascount")
        .get("/newideascount").consumes("application/json").to("direct:newideascount")
        .post("/bye").to("mock:update");
    
    rest("/ideas")
		.post("/create").consumes("application/json").to("direct:createidea");
    
    rest("/tasks")
    	.get("/mytasklist/{id}").consumes("application/json").to("direct:mytasklist");
    
    rest("/test")
    	.get("/get").consumes("application/json").to("direct:testget")
    	.post("/post").to("direct:testpost");

    from("direct:mytaskscount")
    	.log("MyTasksCount method invoked")
        .transform().constant("42");
    
    from("direct:alltaskscount")
		.log("AllTasksCount method invoked")
		.transform().constant("43");
    
    from("direct:myideascount")
		.log("MyIdeasCount method invoked")
		.transform().constant("44");
    
    from("direct:allideascount")
		.log("AllIdeasCount method invoked")
		.transform().constant("45");
    
    from("direct:newideascount")
		.log("AllIdeasCount method invoked")
		.transform().constant("3");
    
    from("direct:mytasklist")
		.log("MyTaskList method invoked")
		.transform().constant("{DUMMY}");
    
    from("direct:testget")
		.log("TestGet method invoked")
		.transform().constant("TestGet method invoked");

    from("direct:testpost")
		.log("TestPost method invoked")
		.transform().constant("TestPost method invoked");
    
    
    from("direct:createidea")
		.log("CreateIdea method invoked")
		.process(new ExchangeLogger())
		.transform().constant("TestPost method invoked");
    
    from("direct:bye")
    	.log("Bye Method Invoked")
        .transform().constant("Bye World");
    }

}
