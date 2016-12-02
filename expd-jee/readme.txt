Getting Started with JEE Development
====================================
JEE is a set of standards that work together to enable efficient development of enterprise class softwae applications.

A Typical JEE application comprises a set of artifacts, each playing a particular role. Although there are many different opinions and approaches, the general approach is to break the application into Layers, for example:
- Persistence Layer, taking responsibility of Db persistence
- Business Logic Layer, taking responsibility of the business-specific functionality of the application
- Presentation Layer, taking responsibility for what the user sees.

These layers are typically represented as different Maven modules.

In modern (2016) JEE development, the following technologies are often employed:
- SOAP Web Services
- REST Web Services
- EJB Session Beans
- EJB Message Driven Beans
- CDI (Context and Dependency Injection)
- JPA (Java Persistence API)
- Bean Validation
- JAXB
- Jackson 
- JSF (Java Server Faces)

Most of these technologies (with the exception of JSF) is very important to 8 BIT PLATOON, and represents technologies that all soldiers need to be comfortable with.

The JEE KitchenSink archetype, tries to bring these technologies together as a cohesive whole, to provide a template for building enterprise-class JEE applications. 

Understanding the different modules in the application
======================================================
The application has multiple modules, each with a specific goal:

jee-kitchensink-ejb
    - Contains a single EJB Session bean which has a widget service
jee-kitchensink-web
    - Contains the REST Endpoints for the EJB service
jee-kitchensink-ear
    - Contains the logic for wrapping the whole application as an EAR archive
jee-kitchensink-model
    - Contains the POJOs and POJI. These specify the domain objects and the interfaces that are implemented by other layers.
jee-kitchensink-utils
    - Cointains utilities that are likely to be used in multiple layers.

How to build the application?
=============================
Each of the individual Maven modules has a POM file, allowing that module to be built individually. 
However, the project contains a parent POM which is used to:
- Define shared dependencies
- Define the group-id
- Define the project version

To build the application, simply go "mvn clean install" from the root folder (i.e. the parent POM)
Everything will pull in automatically. 

You will notice the that sub-POMS never define their own version of group-id. This is all inherited from the Parent POM

Before distributing your application, you will need to version is correctly. This generally means selecting a new version number and applying it to the POMs in your project. Luckily you don't have to do it by hand. The process is quite simple:
- Cd into the parent POM folder
- Use the Maven versions plugin to update the version of the parent POM wherever it is referenced:
    - mvn versions:set -DnewVersion=X.Y.Z-SNAPSHOT
- Just build the app to be sure
- Now commit the change using:
    - mvn versions:commit

How to Deploy the application?
==============================
This application uses MySQL as the database and JPA for managing persistence. 
The persistence configuration will try to create the tables in a defined data
source when you deploy it.

This means you must correctly configure your data source and connect it to the application. Perform the following steps:
* Open jee-kitchensink-ejb/src/main/resources/META-INF/persistence.xml
* Take note of the value in the <jta-data-source> tag
* This is the JNDI name of your data source. It must be defined as a data source (either managed or unmanged)
* I prefer to use managed data sources, so these instructions show how to create a managed data source
* Step 1: Use MySQL Workbench to create a new schema and an associated user
	* Use "jee_kitchensink" for the name of the schema
	* Use "jee_kitchensink" and the username and grant it full schema rights
	* Use "password" as the password
* Step 2: Ensure a MySQL module is configured in WildFly
	* The process is already described in SOAP tutorial 3
	* It really entails storing the JDBC jar in the correct place and defining it in standalone.xml
* Step 3: Create the datasource in the WildFly standalone.xml
	* Make sure WildFly server is stopped
	* Open the relevant standalone.xml file (Depending on which config you run)
	* Find the data sources subsystem tag
	* Add a new data source (copy the previous one and edit as needed)
	* Make the JNDI: java:jboss/datasources/jeeKitchenSinkDS
	* Make the Pool Name: jeeKitchenSinkDS
* Step 4: Test your data source via the WildFly console
	* localhost:9990
	* Runtime > Standalone Server > SubSystems > Data Sources > View
	* Select your data source
	* Click "Test Connection"
	
Once the data source is corectly defined, your should be able to build and deploy the application simply by doing mvn clean install and then dropping the ear file into your WildFly deployment folder.
* Of course, there are faster and simpler ways, depending one how well your IDE is conigured.	

How to use The application
==========================
The endpoints exposed by the application are:

* http://localhost:8080/jee-kitchensink-web/rest/widgets/count
	* GET
	* Gives a count of all the widgets
* http://localhost:8080/jee-kitchensink-web/rest/widgets
	* GET
	* Gives a JSON formatted list of all widgets in the system
* http://localhost:8080/jee-kitchensink-web/rest/widgets/{widgetId}
	* GET
	* Retrieves the identified widget from the DB and returns it as a json string
* http://localhost:8080/jee-kitchensink-web/rest/widgets/create
	* POST
	* Creates a new widget using the input JSON message
* http://localhost:8080/jee-kitchensink-web/rest/widgets/update/{widgetId}
	* POST
	* Updates an existing widget with this widget Id. Uses an input JSON message
* http://localhost:8080/jee-kitchensink-web/rest/widgets/delete/{widgetId}
	* POST
	* Deletes an existing widget with this widget Id. Uses an input JSON message
	
Under the /Testing subfolder there is a single file while was generated using a cool Chrome plugin called ARC.
ARC stands for Advanced REST Client. the project has sample requests for all the methods above, so you can test the project by following these steps:
* Install ARC
* Import the test project.
* Start by adding a widget, then test the other methods.

TODO:
- Add bean validation
- Add Arquilian testing
- Add Sling front end
- Add Camel Flow
- Add sample where entity manager is supplied as a CDI bean, not an EJB injection
- Add better REST-accetable way of handling errors. (Make sure I use the right codes etc.)
- I think I should rather use HTTP PUT for the update method (Not POST)
- I think I should rather use HTTP Delete for the delete method (Not POST)
