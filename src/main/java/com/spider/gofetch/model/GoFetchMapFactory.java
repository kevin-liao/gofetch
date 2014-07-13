/**
 * filename: com.spider.gofetch.model/GoFetchMapFactory.java
 * @author liao
 * @date Jul 11, 2014
 */
package com.spider.gofetch.model;

import java.util.List;

/**
 * The factory class to build the map. It is singleton.
 * 
 * @author liao
 * 
 */
public class GoFetchMapFactory extends MapFactory {
	
	private static GoFetchMapFactory INSTANCE = new GoFetchMapFactory();
	
	private GoFetchMapFactory()
	{
		
	}
	
	/**
	 * @return the singleton instance
	 */
	public static GoFetchMapFactory getInstance()
	{
		return INSTANCE;
	}

	@Override
	public IMap buildMap(String[] stations, List<String> routes) {
		// validate before
		if (stations == null || stations.length == 0 ||
				routes == null || routes.size() == 0)
		{
			return null;
		}
		
		return new GoFetchMap(stations, routes);
	}

}
