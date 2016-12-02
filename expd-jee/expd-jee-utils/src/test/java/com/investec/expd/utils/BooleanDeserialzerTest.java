package com.investec.expd.utils;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.investec.expd.model.Widget;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

/**
 * @author gregf
 *
 */
public class BooleanDeserialzerTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testBooleanDeserialise() {
		System.out.println("@Test - testBooleanDeserialise");
		String jsonString;
		Widget widget;
		
    	try {    	
    		ObjectMapper mapper = new ObjectMapper();
    		SimpleModule module = new SimpleModule();
    		module.addDeserializer(Boolean.class, new BooleanDeserializer());
    		mapper.registerModule(module);
			
    		jsonString = "{\"widget_id\":\"12345\",\"is_active\":\"true\"}";
    		widget = mapper.readValue(jsonString, Widget.class);
			assertEquals(true, widget.getIsActive());
			
    		jsonString = "{\"widget_id\":\"12345\",\"is_active\":\"false\"}";
    		widget = mapper.readValue(jsonString, Widget.class);
			assertEquals(false, widget.getIsActive());		
			
    		jsonString = "{\"widget_id\":\"12345\",\"is_active\":\"1\"}";
    		widget = mapper.readValue(jsonString, Widget.class);
			assertEquals(true, widget.getIsActive());
			
    		jsonString = "{\"widget_id\":\"12345\",\"is_active\":\"0\"}";
    		widget = mapper.readValue(jsonString, Widget.class);
			assertEquals(false, widget.getIsActive());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
