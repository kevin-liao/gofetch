/**
 * filename: com.spider.gofetch.dijkstra/GoFetchLinkedDirectedGraph.java
 * @author liao
 * @date Jul 11, 2014
 */
package com.spider.gofetch.dijkstra;

import java.util.List;

/**
 * @author liao
 * 
 */
public class DijkstraGraph {

	private final List<Vertex> vertexes;
	private final List<Edge> edges;

	public DijkstraGraph(List<Vertex> vertexes, List<Edge> edges) {
		this.vertexes = vertexes;
		this.edges = edges;
	}

	public List<Vertex> getVertexes() {
		return vertexes;
	}

	public List<Edge> getEdges() {
		return edges;
	}

}
