package com.investec.expd.utils;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.investec.expd.model.Widget;
import com.fasterxml.jackson.core.JsonParseException;

/**
 * @author gregf
 *
 */
public class WidgetJsonUtilsTest {

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
	public void testCreateWidgetObjectFromJsonString() {
		WidgetJsonUtils utils = new WidgetJsonUtils();
		
    	try {
    		// Read test JSON file into string
    		ClassLoader classLoader = getClass().getClassLoader();
    		File file = new File(classLoader.getResource("SampleJsonFiles/Widget_ForJUnitChecks.json").getFile());
			String jsonString = FileUtils.readFileToString(file, "UTF-8");
			
			// Marshal to Java Object
			Widget widget = utils.createWidgetObjectFromJsonString(jsonString);
			
			// Check String Property Values
			assertEquals(12345, widget.getWidgetId());
			assertEquals("Test Widget", widget.getWidgetName());
			
			// Check Boolean Property Values
			assertEquals(true, widget.getIsActive());
			
			// Check Date Property Values
			SimpleDateFormat sdfTimestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ssZ");
			sdfTimestamp.setTimeZone(TimeZone.getTimeZone("GMT+2"));
						
			assertEquals("2016-04-20 04:58:49+0200", sdfTimestamp.format(widget.getChangedTime()));

			System.out.println("@Test - testCreateWidgetObjectFromJsonString");
			System.out.println("Widget that was read from JSON file: ");
			System.out.println(widget.toString());
    	} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
