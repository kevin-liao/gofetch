/**
 * filename: com.spider.gofetch.model/RouteDetail.java
 * @author liao
 * @date Jul 11, 2014
 */
package com.spider.gofetch.model;

import java.util.List;

/**
 * @author liao
 *
 */
public class RouteDetail {
	
	/**
	 * the distance of this route
	 */
	private int distance;
	
	/**
	 * the path of the route, indicating starts from which station,
	 * passing by stations, and the end station.
	 */
	private List<String> path;

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public List<String> getPath() {
		return path;
	}

	public void setPath(List<String> path) {
		this.path = path;
	}
	
	/**
	 * @return the string text has distance and detail path/route information. 
	 */
	public String buildTheRouteDetail()
	{
		if (path == null || path.size() == 0)
		{
			return "";
		}
		
		StringBuffer sb = new StringBuffer();
		sb.append("1) distance: ").append(distance).append(".\n");
		sb.append("2) route detail: ");
		int size = path.size();
		for (int i = 0; i < size; i++ )
		{
			if (i == size - 1)
			{
				sb.append(path.get(i));
			}
			else
			{
				sb.append(path.get(i)).append("->");
			}
		}
		return sb.toString();
	}

}
