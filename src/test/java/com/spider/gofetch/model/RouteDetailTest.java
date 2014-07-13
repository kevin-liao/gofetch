/**
 * filename: com.spider.gofetch.model/RouteDetailTest.java
 * @author liao
 * @date Jul 11, 2014
 */
package com.spider.gofetch.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;


/**
 * Unit Test for RouteDetail class.
 * 
 * @author liao
 *
 */
public class RouteDetailTest {
	
	@Test
	public void testSetterAndGetter() {
		RouteDetail detail = new RouteDetail();
		assertEquals(0, detail.getDistance());
		assertNull(detail.getPath());
		
		List<String> stations = new LinkedList<String>();
		stations.add("A");
		stations.add("B");
		detail.setDistance(100);
		detail.setPath(stations);
		
		assertEquals(100, detail.getDistance());
		assertNotNull(detail.getPath());
		assertEquals("A", detail.getPath().get(0));
		assertEquals("B", detail.getPath().get(1));
		assertEquals("1) distance: 100.\n2) route detail: A->B", detail.buildTheRouteDetail());
	}

}
