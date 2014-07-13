/**
 * filename: com.spider.gofetch.util/GoFetchUtil.java
 * @author liao
 * @date Jul 11, 2014
 */
package com.spider.gofetch.util;

import java.util.ArrayList;
import java.util.List;

import com.spider.gofetch.dijkstra.DijkstraGraph;
import com.spider.gofetch.dijkstra.Edge;
import com.spider.gofetch.dijkstra.Vertex;

/**
 * Utility class in the application.
 * 
 * @author liao
 * 
 */
public class GoFetchUtil {

	/**
	 * build the detail for Journey Planner result.
	 * 
	 * 
	 * @param paths the list of path
	 * @return the path string value
	 */
	public static String buildDetailForJourneyPlannerResult(List<List<String>> paths)
	{
		if (paths == null || paths.size() == 0)
		{
			return null;
		}
		
		int size = paths.size();
		StringBuffer sb = new StringBuffer();
		sb.append(size + " possible path. ");
		for (int i = 0; i < size; i++)
		{
			List<String> path = paths.get(i);
			int indexFromOne = i + 1;
			sb.append("The [" + indexFromOne + "] path: ").append(buildFormattedPathString(path)).append(".\n");
		}
		return sb.toString();
	}
	
	private static String buildFormattedPathString(List<String> path)
	{
		if (path == null || path.size() == 0)
		{
			return "";
		}
		int size = path.size();
		StringBuffer sb = new StringBuffer();
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

	/**
	 * 
	 * @return
	 */
	public static String[] loadVexDataStorage() {
		// this is the mock of vex
		String[] vex = new String[10];
		vex[0] = "A";
		vex[1] = "B";
		vex[2] = "C";
		vex[3] = "D";
		vex[4] = "E";
		vex[5] = "F";
		vex[6] = "G";
		vex[7] = "H";
		vex[8] = "I";
		vex[9] = "J";

		return vex;
	}

	/**
	 * 
	 * @return
	 */
	public static List<String> loadEdgesFromDataStorage() {
		List<String> edges = new ArrayList<String>();
		// 4 starting from A
		edges.add("AB12");
		edges.add("AD19");
		edges.add("AE20");
		edges.add("AG16");

		// 2 from B
		edges.add("BC5");
		edges.add("BD13");
		edges.add("BI15");

		edges.add("CD5");

		edges.add("DE7");

		edges.add("EF5");

		edges.add("FA5");

		edges.add("GF11");

		edges.add("HA4");
		edges.add("HB19");
		edges.add("HG6");

		edges.add("IH15");
		edges.add("IJ10");

		edges.add("JB7");
		edges.add("JC15");

		return edges;
	}

	/**
	 * 
	 * @param route
	 * 
	 * @return true is the route is valid, false if it is not valid
	 */
	public static boolean isValidRouteString(String route) {
		// if the route is null or empty
		if (route == null || route.equals("") || route.trim().equals("")) {
			return false;
		}

		return true;
	}

	/**
	 * 
	 * @param vexs
	 *            the string array of vertex
	 * @param edges
	 *            the string list of edge
	 * @return the DijkstraGraph
	 */
	public static DijkstraGraph buildDijkstraGraph(String[] vexs,
			List<String> edges) {
		// validate before
		if (vexs == null || vexs.length == 0 || edges == null
				|| edges.size() == 0) {
			return null;
		}

		List<Vertex> dijkVertexes = new ArrayList<Vertex>();
		List<Edge> dijkEdges = new ArrayList<Edge>();
		int vlen = vexs.length;
		for (int i = 0; i < vlen; i++) {
			Vertex vertex = new Vertex(vexs[i]);
			dijkVertexes.add(vertex);
		}

		int elen = edges.size();
		try {
			for (int i = 0; i < elen; i++) {
				// parse the edge representation, AB10
				String from = edges.get(i).substring(0, 1);
				String to = edges.get(i).substring(1, 2);
				String weightStr = edges.get(i).substring(2);
				int weight = Integer.parseInt(weightStr);

				Vertex src = getDijkVertexByName(dijkVertexes, from);
				Vertex dest = getDijkVertexByName(dijkVertexes, to);
				Edge edge = new Edge(src, dest, weight);
				dijkEdges.add(edge);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new DijkstraGraph(dijkVertexes, dijkEdges);
	}

	/**
	 * 
	 * @param dijkVertexes
	 * @param name
	 * @return
	 */
	public static Vertex getDijkVertexByName(List<Vertex> dijkVertexes,
			String name) {
		if (dijkVertexes == null || dijkVertexes.size() == 0) {
			return null;
		}

		Vertex target = null;
		for (Vertex vertex : dijkVertexes) {
			if (vertex.getName().equals(name)) {
				target = vertex;
			}
		}
		return target;
	}
}
