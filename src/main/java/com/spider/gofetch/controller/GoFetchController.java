/**
 * filename: com.spider.gofetch.controller/GoFetchController.java
 * @author liao
 * @date Jul 14, 2014
 */
package com.spider.gofetch.controller;

import java.util.List;

import org.apache.log4j.Logger;

import com.spider.gofetch.model.GoFetchMapFactory;
import com.spider.gofetch.model.IMap;
import com.spider.gofetch.model.RouteDetail;
import com.spider.gofetch.util.GoFetchUtil;

/**
 * The controller class of this application. 
 * It split the interaction between view and business.
 * 
 * @author liao
 *
 */
public class GoFetchController {
	
	/**
	 * the logger instance
	 */
	private static Logger logger = Logger.getLogger(GoFetchController.class);
	
	/**
	 * the map instance inside the controller
	 */
	private IMap goFetchMap;
	
	public GoFetchController()
	{
		
	}
	
	public GoFetchController(IMap goFetchMap) {
		super();
		this.goFetchMap = goFetchMap;
	}
	
	public IMap getGoFetchMap()
	{
		return goFetchMap;
	}

	/**
	 * load the map
	 */
	public void loadMap()
	{
		// load the data and build the map
		String[] vexs = GoFetchUtil.loadVexDataStorage();
		List<String> edges = GoFetchUtil.loadEdgesFromDataStorage();
		goFetchMap = GoFetchMapFactory.getInstance().buildMap(vexs, edges);
	}
	
	/**
	 * This method is to calculate the distance for the given route.
	 * 
	 * @param map
	 *            the map instance
	 * @param route
	 *            the string contains all stations in the route
	 * 
	 * @return the distance of this specific route if it is a valid route.
	 *         otherwise return the message to tell customer the route is
	 *         invalid.
	 */
	public String calculateDistanceForRoute(String route) {
		// if map is null
		if (goFetchMap == null) {
			return "the map is null. please load the map firstly.";
		}
		// check the route string is valid or not
		if (!GoFetchUtil.isValidRouteString(route)) {
			String message = "the route string is invalid. please correct it.";
			logger.info(message);
			return message;
		}

		// check the route is valid or not by map
		if (!goFetchMap.isValidRoute(route)) {
			String message = "the route is invalid. please input the correct route.";
			logger.info(message);
			return message;
		}

		return goFetchMap.calculateDistance(route) + "";
	}

	/**
	 * This method is to try to find the shortest route between from and to
	 * station
	 * 
	 * @param from
	 *            the from station
	 * @param to
	 *            the to station
	 * @return
	 */
	public String findShortestRoute( String from, String to) {
		// if map is null
		if (goFetchMap == null) {
			return "the map is null. please load the map firstly.";
		}

		// if the from and to is null or empty
		if (from == null || from.equals("") || to == null || to.equals("")) {
			return "The from and to string is invalid. please correct it.";
		}

		// check the route is valid or not by map
		if (!goFetchMap.isValidStation(from) || !goFetchMap.isValidRoute(to)) {
			return "either start or end station is invalid. please input the correct station.";
		}

		RouteDetail detail = goFetchMap.findShortestRoute(from, to);
		if (detail == null) {
			return "could not find the shortest route between start or end station. please try other stations.";
		} else {
			return detail.buildTheRouteDetail();
		}
	}

	/**
	 * 
	 * @param from the from station
	 * @param to the to station
	 * @param stops the number of stops
	 * @return
	 */
	public String calculatePossibilitiesForRoute(String from, String to,
			String stops) {
		// if map is null
		if (goFetchMap == null) {
			String message = "the map is null. please load the map firstly.";
			logger.info(message);
			return message;
		}

		// if the from and to is null or empty
		if (from == null || from.equals("") || to == null || to.equals("")) {
			String message = "The from and to string is invalid. please correct it.";
			logger.info(message);
			return message;
		}

		// stops must be the integer numbers
		int numberOfStop = -1;
		if (stops != null && !stops.equals("")) {
			try {
				numberOfStop = Integer.parseInt(stops);
			} catch (Exception e) {
				logger.error(e.getStackTrace());
				return "The stops must be a number.";
			}
		}

		// check the route is valid or not by map
		if (!goFetchMap.isValidStation(from) || !goFetchMap.isValidRoute(to)) {
			String message = "either start or end station is invalid. please input the correct station.";
			logger.info(message);
			return message;
		}

		List<List<String>> paths = goFetchMap.calculatePossibilitiesForRoute(from, to, numberOfStop);
		if (paths == null || paths.size() == 0)
		{
			return "no path found. please try other station.";
		}
		
		return GoFetchUtil.buildDetailForJourneyPlannerResult(paths);
	}
}
