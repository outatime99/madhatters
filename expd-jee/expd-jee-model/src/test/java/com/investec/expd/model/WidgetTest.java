package com.investec.expd.model;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author gregf
 *
 */
public class WidgetTest {
	
	Widget widget;

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
		widget = new Widget();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link com.investec.expd.model.Widget#getWidgetId()}.
	 */
	@Test
	public void testGetSetWidgetId() {
		widget.setWidgetId(12345);
		System.out.println("Property::WidgetId="+widget.getWidgetId());
		assertEquals(12345, widget.getWidgetId());
		widget.setWidgetId(54321);
		System.out.println("Property::WidgetId="+widget.getWidgetId());
		assertEquals(54321, widget.getWidgetId());		
	}
	
	@Test
	public void testGetSetWidgetName() {
		widget.setWidgetName("TestName");
		System.out.println("Property::WidgetName="+widget.getWidgetName());
		assertEquals("TestName", widget.getWidgetName());	
	}	
	
	/**
	 * Test method for {@link com.investec.expd.model.Widget#isActive()}.
	 */
	@Test
	public void testGetSetIsActive() {
		widget.setIsActive(true);
		System.out.println("Property::IsActive="+widget.getIsActive());
		assertEquals(true, widget.getIsActive());
		widget.setIsActive(false);
		System.out.println("Property::IsActive="+widget.getIsActive());
		assertEquals(false, widget.getIsActive());		
	}	
	
	@Test
	public void testGetSetChangedTime() {
		SimpleDateFormat sdfTimestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ssZ");
		sdfTimestamp.setTimeZone(TimeZone.getTimeZone("GMT+2"));
		
		Date now = new Date();
		widget.setChangedTime(now);
		
		System.out.println("Property::ChangedTime="+ sdfTimestamp.format(widget.getChangedTime()));
		assertEquals(now, widget.getChangedTime());		
	}

}
