/**
 * filename: com.spider.gofetch.model/IGraph.java
 * @author liao
 * @date Jul 11, 2014
 */
package com.spider.gofetch.model;

import java.util.List;

/**
 * The interface of map in the application. It has the basic requirements for 
 * the map.
 * 
 * @author liao
 *
 */
public interface IMap {
	
	/**
	 * This function is to check the route is valid or not in graph.
	 * 
	 * @param route the route need to check
	 * @return true if it is valid route
	 */
	public boolean isValidRoute(String route);
	
	/**
	 * This function is to check the station is valid or not in graph.
	 * 
	 * @param station the station need to check
	 * @return true if it is valid station defined in graph
	 */
	public boolean isValidStation(String station);
	
	/**
	 * This function is to get all stations in the graph/map.
	 * 
	 * @return the station array
	 */
	public String[] getAllStations();
	
	/**
	 * This function is to calculation the distance in the given route
	 * 
	 * @param route the route need to calculate the distance
	 * @return the distance of this valid route
	 */
	public int calculateDistance(String route);
	
	/**
	 * This method is to get the shortest route between two stations. 
	 * Those two stations could be the same one.
	 * 
	 * @param from the from station
	 * @param to the to station
	 * @return the RouteDetail object
	 */
	public RouteDetail findShortestRoute(String from, String to);
	
	/**
	 * This method is to get all the possible routes between two stations. 
	 * 
	 * @param from the from station
	 * @param to the to station
	 * @param stops the number of "stops" along the way
	 * 
	 * @return the all possible routes between two stations
	 */
	public List<List<String>> calculatePossibilitiesForRoute(String from, String to, int stops);

}
