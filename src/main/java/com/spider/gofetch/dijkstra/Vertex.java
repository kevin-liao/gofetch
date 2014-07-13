/**
 * filename: com.spider.gofetch.dijkstra/Vertex.java
 * @author liao
 * @date Jul 11, 2014
 */
package com.spider.gofetch.dijkstra;

/**
 * Class for Vertex in Dijkstra Graph
 * 
 * @author liao
 * 
 */
public class Vertex {

	final private String name;

	public Vertex(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vertex other = (Vertex) obj;
		if (name == null) {
			if (other.getName() != null) {
				return false;
			}
		} else if (!name.equals(other.getName()))
		{
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return name;
	}
}
