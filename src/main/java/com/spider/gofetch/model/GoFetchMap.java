/**
 * filename: com.spider.gofetch.model/GoFetchMap.java
 * @author liao
 * @date Jul 11, 2014
 */
package com.spider.gofetch.model;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import com.spider.gofetch.dijkstra.DijkstraAlgorithm;
import com.spider.gofetch.dijkstra.DijkstraGraph;
import com.spider.gofetch.dijkstra.Vertex;
import com.spider.gofetch.util.GoFetchUtil;

/**
 * The implementation of IMap in the application. 
 * 
 * @author liao
 * 
 */
public class GoFetchMap implements IMap {

	private static final String DELIMITER_BETWEEN_STATIONS = "-";

	private String[] mVexs; // the set of stations
	private int[][] mMatrix; // the set of edges
	
	/**
	 * just a temp list for edges
	 */
	private List<String> edges;

	/**
	 * 
	 */
	public GoFetchMap() {

	}

	/**
	 * @param stations
	 *            the set of stations, example: [A, B, C, ...]
	 * @param routes
	 *            the set of routes including the weight the example is AB10, BC10.
	 */
	public GoFetchMap(String[] vexs, List<String> edges) {

		int vlen = vexs.length;
		int elen = edges.size();

		// initial the vertex
		mVexs = new String[vlen];
		for (int i = 0; i < mVexs.length; i++) {
			mVexs[i] = vexs[i];
		}

		// initial the edge
		mMatrix = new int[vlen][vlen];
		try {
			for (int i = 0; i < elen; i++) {
				//
				String fromStation = edges.get(i).substring(0, 1);
				String toStation = edges.get(i).substring(1, 2);
				String weightStr = edges.get(i).substring(2);
				int weight = Integer.parseInt(weightStr);

				int p1 = getPosition(fromStation);
				int p2 = getPosition(toStation);
				mMatrix[p1][p2] = weight;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		this.edges = edges;
	}

	/**
	 * return the position of station in matrix
	 * 
	 * @param station
	 * @return the position of station in the matrix
	 */
	private int getPosition(String station) {
		//
		for (int i = 0; i < mVexs.length; i++) {
			if (mVexs[i].equals(station)) {
				return i;
			}
		}

		return -1;
	}

	/**
	 * return the position of first adjcent of current vertex
	 */
	private int firstVertex(int v) {

		if (v < 0 || v > (mVexs.length - 1)) {
			return -1;
		}

		for (int i = 0; i < mVexs.length; i++) {
			if (mMatrix[v][i] > 0) {
				return i;
			}
		}

		return -1;
	}

	/**
	 * 
	 * @param v
	 *            the current vertex
	 * @param w
	 * @return
	 */
	private int nextVertex(int v, int w) {

		if (v < 0 || v > (mVexs.length - 1) || w < 0 || w > (mVexs.length - 1)) {
			return -1;
		}

		for (int i = w + 1; i < mVexs.length; i++) {
			if (mMatrix[v][i] > 0) {
				return i;
			}
		}

		return -1;
	}

	/**
	 * 
	 * @param from
	 * @param to
	 * @return
	 */
	private List<List<String>> getAllPaths(String from, String to) {
		List<List<String>> paths = new ArrayList<List<String>>();
		getAllPaths(from, to, paths, new LinkedHashSet<String>());
		return paths;
	}

	/**
	 * 
	 * @param current
	 * @param destination
	 * @param paths
	 *            all paths for the current to destination
	 * @param path the current path
	 */
	private void getAllPaths(String current, String to,
			List<List<String>> paths, LinkedHashSet<String> path) {
		path.add(current);

		if (current.equals(to)) {
			paths.add(new ArrayList<String>(path));
			path.remove(current);
			return;
		}

		final Set<String> edges = getEdgesFrom(current);

		for (String t : edges) {
			if (!path.contains(t)) {
				getAllPaths(t, to, paths, path);
			}
		}

		path.remove(current);
	}

	/**
	 * 
	 * @param from the from vertex
	 * @return
	 */
	private Set<String> getEdgesFrom(String from) {
		Set<String> edges = new LinkedHashSet<String>();
		int v = getPosition(from);
		for (int i = 0; i < mVexs.length; i++) {
			if (mMatrix[v][i] > 0) {
				edges.add(mVexs[i]);
			}
		}
		return edges;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.spider.gofetch.model.IGraph#isValidRoute()
	 */
	@Override
	public boolean isValidRoute(String route) {
		// TODO Auto-generated method stub
		if (route == null || route.equals("")) {
			return false;
		}

		String[] stations = route.split(DELIMITER_BETWEEN_STATIONS);
		if (stations == null || stations.length == 0) {
			return false;
		}

		// step1, validate all stations in the route
		int size = stations.length;
		for (int i = 0; i < size; i++) {
			String station = stations[i];
			if (!isValidStation(station)) {
				return false;
			}
		}

		// setp2, validate the edge
		for (int i = 0, j = 1; i < size - 1 && j < size; i++, j++) {
			String fromStation = stations[i];
			String toStation = stations[j];
			int p1 = getPosition(fromStation);
			int p2 = getPosition(toStation);
			if (mMatrix[p1][p2] == 0) {
				return false;
			}
		}

		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.spider.gofetch.model.IGraph#isValidStation()
	 */
	@Override
	public boolean isValidStation(String station) {
		for (String vex : this.mVexs) {
			if (vex.equals(station)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * check any given string edge is valid or not. The from station and end
	 * station are existed and the edge is not equal 0.
	 * 
	 * For example, 1) AB is the valid edge 2) A-B is NOT 3) 1ab is NOT
	 * 
	 * @param station
	 *            the specific station
	 * @return true if it is in the list, false it is not.
	 */
	private boolean isValidEdge(String edge) {
		if (edge == null || edge.trim().equals("") || edge.length() != 2) {
			return false;
		}

		String fromStation = edge.substring(0, 1);
		String toStation = edge.substring(1, 2);
		int p1 = getPosition(fromStation);
		int p2 = getPosition(toStation);

		if (mMatrix[p1][p2] != 0) {
			return true;
		}

		return false;
	}

	/**
	 * Breadth-First-Search
	 */
	public void BFS() {
		int head = 0;
		int rear = 0;
		int[] queue = new int[mVexs.length];
		boolean[] visited = new boolean[mVexs.length];

		for (int i = 0; i < mVexs.length; i++)
			visited[i] = false;

		System.out.printf("BFS: ");
		for (int i = 0; i < mVexs.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				System.out.printf("%c ", mVexs[i]);
				queue[rear++] = i;
			}

			while (head != rear) {
				int j = queue[head++];
				for (int k = firstVertex(j); k >= 0; k = nextVertex(j, k)) { // k是为访问的邻接顶点
					if (!visited[k]) {
						visited[k] = true;
						System.out.printf("%c ", mVexs[k]);
						queue[rear++] = k;
					}
				}
			}
		}
		System.out.printf("\n");
	}

	/**
	 * Deep-First-Search
	 */
	public void DFS() {
		boolean[] visited = new boolean[mVexs.length];

		// not visited in the beginning
		for (int i = 0; i < mVexs.length; i++) {
			visited[i] = false;
		}

		for (int i = 0; i < mVexs.length; i++) {
			if (!visited[i]) {
				deepFirstSearch(i, visited);
			}
		}
	}

	/**
	 * 
	 * @param from
	 * @param to
	 * @return true if it is achievable
	 */
	private boolean isAchievable(int from, int to) {
		boolean[] visited = new boolean[mVexs.length];

		// not visited in the beginning
		for (int i = 0; i < mVexs.length; i++) {
			visited[i] = false;
		}

		deepFirstSearch(from, visited);
		if (visited[to]) {
			return true;
		} else {
			return false;
		}
	}

	private void deepFirstSearch(int i, boolean[] visited) {
		visited[i] = true;
		//
		for (int w = firstVertex(i); w >= 0; w = nextVertex(i, w)) {
			if (!visited[w]) {
				deepFirstSearch(w, visited);
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.spider.gofetch.model.IGraph#calculateDistance(java.lang.String)
	 */
	@Override
	public int calculateDistance(String route) {
		//
		String[] stations = route.split(DELIMITER_BETWEEN_STATIONS);
		if (stations == null || stations.length == 0) {
			return 0;
		}

		int size = stations.length;
		int distance = 0;
		// iterate all edge on the route
		for (int i = 0, j = 1; i < size - 1 && j < size; i++, j++) {
			String fromStation = stations[i];
			String toStation = stations[j];
			int p1 = getPosition(fromStation);
			int p2 = getPosition(toStation);

			distance += mMatrix[p1][p2];
		}

		return distance;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.spider.gofetch.model.IGraph#findShortestRoute(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public RouteDetail findShortestRoute(String from, String to) {
		// step1. check those two vertex are achievable or not
		int p1 = getPosition(from);
		int p2 = getPosition(to);
		if (!isAchievable(p1, p2)) {
			return null;
		}
		
		// step2. build a dijkstra graph to find all shorted path
		DijkstraGraph dijkstraGraph = GoFetchUtil.buildDijkstraGraph(mVexs, edges);
		DijkstraAlgorithm algorithm = new DijkstraAlgorithm(dijkstraGraph);
		Vertex src = GoFetchUtil.getDijkVertexByName(dijkstraGraph.getVertexes(), from);
		Vertex dest = GoFetchUtil.getDijkVertexByName(dijkstraGraph.getVertexes(), to);
		algorithm.execute(src);
		List<String> path = algorithm.getPath(dest);
		
		// step3. transfer to the RouteDetail object
		RouteDetail detail = new RouteDetail();
		detail.setPath(path);
		int distance = calculateDistanceForPath(path);
		detail.setDistance(distance);
		return detail;
	}
	
	private int calculateDistanceForPath(List<String> path)
	{
		if (path == null || path.size() == 0) {
			return 0;
		}

		int size = path.size();
		int distance = 0;
		// iterate all edge on the route
		for (int i = 0, j = 1; i < size - 1 && j < size; i++, j++) {
			String fromStation = path.get(i);
			String toStation = path.get(j);
			int p1 = getPosition(fromStation);
			int p2 = getPosition(toStation);
			distance += mMatrix[p1][p2];
		}

		return distance;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.spider.gofetch.model.IGraph#calculatePossibilitiesForRoute(java.lang
	 * .String, java.lang.String, int)
	 */
	@Override
	public List<List<String>> calculatePossibilitiesForRoute(String from, String to, int stops) {
		// step1. check the achievable or not
		int p1 = getPosition(from);
		int p2 = getPosition(to);
		if (!isAchievable(p1, p2)) {
			return null;
		}

		// step2. find all possible paths while connect from and to
		return getAllPaths(from, to);
	}

	/*
	 * (non-Javadoc)
	 * @see com.spider.gofetch.model.IGraph#getAllStations()
	 */
	@Override
	public String[] getAllStations() {
		return this.mVexs;
	}

}
