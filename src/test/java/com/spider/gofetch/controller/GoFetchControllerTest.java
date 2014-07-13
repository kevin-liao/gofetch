/**
 * filename: com.spider.gofetch.controller/GoFetchControllerTest.java
 * @author liao
 * @date Jul 14, 2014
 */
package com.spider.gofetch.controller;

import org.junit.Test;

import com.spider.gofetch.model.GoFetchBaseTest;
import com.spider.gofetch.model.IMap;

/**
 * Unit Test for GoFetchController
 * 
 * @author liao
 *
 */
public class GoFetchControllerTest extends GoFetchBaseTest {

	private IMap map;
	
	private GoFetchController controller = new GoFetchController();
	
	@Override
	protected void setUp() throws Exception {
		controller.loadMap();
	}
	
	@Test
	public void testCalculateDistanceForRoute() {
		// 
		assertEquals("12", controller.calculateDistanceForRoute("A-B"));
	}
}
