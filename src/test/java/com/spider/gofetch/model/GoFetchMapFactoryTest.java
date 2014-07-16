/**
 * filename: com.spider.gofetch.model/GoFetchMapFactoryTest.java
 * @author liao
 * @date Jul 14, 2014
 */
package com.spider.gofetch.model;

import java.util.List;

import org.junit.Test;

/**
 * Unit Test for GoFetchMapFactory
 * 
 * @author liao
 *
 */
public class GoFetchMapFactoryTest extends GoFetchBaseTest{
	
	@Test
	public void testGetInstance() {
		GoFetchMapFactory i1 = GoFetchMapFactory.getInstance();
		GoFetchMapFactory i2 = GoFetchMapFactory.getInstance();
		
		assertSame(i1, i2);
	}
	
	
	@Test
	public void testBuildMap() {
		GoFetchMapFactory factory = GoFetchMapFactory.getInstance();
		String[] stations = mockStationsForMap();
		List<String> routes = mockRoutesForMap();
		IMap map = factory.buildMap(stations, routes);
		assertEquals(12, map.calculateDistance("A-B"));
		
		List<List<String>> paths = map.calculatePossibilitiesForRoute("A", "C");
		assertEquals(2, paths.size());
		assertEquals(3, paths.get(1).size());
	}

}
