/**
 * filename: com.spider.gofetch.dijkstra/DijkstraAlgorithmTest.java
 * @author liao
 * @date Jul 14, 2014
 */
package com.spider.gofetch.dijkstra;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import junit.framework.TestCase;

import org.junit.Test;

/**
 * Unit Test for DijkstraAlgorithm
 * 
 * @author liao
 * 
 */
public class DijkstraAlgorithmTest extends TestCase {

	List<Vertex> vertexes;
	List<Edge> edges;
	private DijkstraAlgorithm da;

	@Override
	protected void setUp() throws Exception {
		vertexes = mockVertexes();
		edges = mockEdges(vertexes);
		DijkstraGraph dGraph = new DijkstraGraph(vertexes, edges);
		da = new DijkstraAlgorithm(dGraph);
	}

	@Test
	public void testFindShortestRoute() {
		Vertex v1 = vertexes.get(0);
		Vertex v2 = vertexes.get(2);
		da.execute(v1);
		List<String> path = da.getPath(v2);
		assertEquals(2, path.size());
		assertEquals("A", path.get(0));
		assertEquals("C", path.get(1));
	}

	private List<Vertex> mockVertexes() {
		List<Vertex> vertexes = new LinkedList<Vertex>();
		Vertex v1 = new Vertex("A");
		Vertex v2 = new Vertex("B");
		Vertex v3 = new Vertex("C");
		Vertex v4 = new Vertex("D");

		vertexes.add(v1);
		vertexes.add(v2);
		vertexes.add(v3);
		vertexes.add(v4);
		return vertexes;
	}

	private List<Edge> mockEdges(List<Vertex> vertexes) {
		List<Edge> edges = new ArrayList<Edge>();

		Edge e1 = new Edge(vertexes.get(0), vertexes.get(1), 2);
		Edge e2 = new Edge(vertexes.get(0), vertexes.get(2), 6);
		Edge e3 = new Edge(vertexes.get(0), vertexes.get(3), 2);
		Edge e4 = new Edge(vertexes.get(1), vertexes.get(2), 15);
		Edge e5 = new Edge(vertexes.get(3), vertexes.get(2), 9);

		// add the edge
		edges.add(e1);
		edges.add(e2);
		edges.add(e3);
		edges.add(e4);
		edges.add(e5);

		return edges;
	}
}
