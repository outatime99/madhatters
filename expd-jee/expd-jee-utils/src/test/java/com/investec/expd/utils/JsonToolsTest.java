package com.investec.expd.utils;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonNode;

import org.apache.commons.io.FileUtils;
import org.junit.*;

import static org.junit.Assert.*;

/**
 * Unit test for JsonTools
 */
public class JsonToolsTest {

    @BeforeClass
    public static void oneTimeSetUp() {
        // one-time initialization code   
    	System.out.println("@BeforeClass - oneTimeSetUp");
    }

    @AfterClass
    public static void oneTimeTearDown() {
        // one-time cleanup code
    	System.out.println("@AfterClass - oneTimeTearDown");
    }

    @Before
    public void setUp() {
    	// Setup before each test
        System.out.println("@Before - setUp");
    }

    @After
    public void tearDown() {
    	// Teardown after each test
        System.out.println("@After - tearDown");
    }

    /**
     * 
     */
    @Test
    public void testMarshalStringToJsonNode()
    {
    	System.out.println("@Test - testMarshalStringToJsonNode");
    	JsonTools tools = new JsonTools();
    	String jsonString = "{\"k1\":\"v1\",\"k2\":\"v2\"}";
    	
    	JsonNode actualObj;
		try {
			actualObj = tools.marshalStringToJsonNode(jsonString);
			JsonNode jsonNode1 = actualObj.get("k1");
			assertEquals("v1", jsonNode1.textValue());
			System.out.println("Value: " +  jsonNode1.textValue());
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    /**
     * 
     */
    @Test
    public void testMarshalFileToJsonNode()
    {
		System.out.println("@Test - testMarshalFileToJsonNode");
    	JsonTools tools = new JsonTools();
    	
    	try {
    		ClassLoader classLoader = getClass().getClassLoader();
    		File file = new File(classLoader.getResource("SampleJsonFiles/Widget_ForJUnitChecks.json").getFile());
			String jsonString = FileUtils.readFileToString(file, "UTF-8");
			JsonNode actualObj;
			actualObj = tools.marshalStringToJsonNode(jsonString);
			JsonNode jsonNode1 = actualObj.get("widget_id");
			assertEquals("12345", jsonNode1.textValue());

		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }    
    
}
