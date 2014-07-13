/**
 * filename: com.spider.gofetch.model/MapFactory.java
 * @author liao
 * @date Jul 11, 2014
 */
package com.spider.gofetch.model;

import java.util.List;

/**
 * The abstract class for map factory.
 * 
 * @author liao
 *
 */
public abstract class MapFactory {
	
	/**
	 * Build the map based on given stations and routes
	 * 
	 * @param stations the station array.
	 * @param routes the route list. 
	 * It would be like ('station' + 'station' + 'distance').
	 * example: 'AB10', 'XY20'
	 * 
	 * @return the instance of IMap
	 */
	public abstract IMap buildMap(String[] stations, List<String> routes);

}
