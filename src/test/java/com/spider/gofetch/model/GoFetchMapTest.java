/**
 * filename: com.spider.gofetch.model/GoFetchMapTest.java
 * @author liao
 * @date Jul 14, 2014
 */
package com.spider.gofetch.model;

import java.util.List;

import org.junit.Test;

/**
 * Unit Test for GoFetchMap
 * 
 * @author liao
 *
 */
public class GoFetchMapTest extends GoFetchBaseTest{
	
	private IMap map;
	
	@Override
	protected void setUp() throws Exception {
		GoFetchMapFactory factory = GoFetchMapFactory.getInstance();
		String[] stations = mockStationsForMap();
		List<String> routes = mockRoutesForMap();
		map = factory.buildMap(stations, routes);
	}

	
	@Test
	public void testCalculateDistance() {
		
		assertEquals(17, map.calculateDistance("A-B-C"));
		assertEquals(26, map.calculateDistance("A-D-C"));
	}
	
	@Test
	public void testCalculateDistance_failedNullRoute() {
		
		assertEquals(0, map.calculateDistance(null));
		assertEquals(0, map.calculateDistance(""));
	}
	
	@Test
	public void testCalculatePossibilitiesForRoute() {
		List<List<String>> paths = map.calculatePossibilitiesForRoute("A", "C", 1);
		assertEquals(2, paths.size());
		assertEquals(3, paths.get(1).size());
	}
}
