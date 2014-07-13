/**
 * filename: com.spider.gofetch.util/GoFetchUtilTest.java
 * @author liao
 * @date Jul 11, 2014
 */
package com.spider.gofetch.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.spider.gofetch.model.IMap;

/**
 * @author liao
 *
 */
public class GoFetchUtilTest {

	@Test
	public void testCalculateDistanceForRoute() {
		IMap graph = null;
		String route = "AB";
		String distance = GoFetchUtil.calculateDistanceForRoute(graph, route);
		assertEquals(distance, "the map is null. please load the map firstly.");
	}
}
