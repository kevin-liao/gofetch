/**
 * filename: com.spider.gofetch.model/GoFetchBaseTest.java
 * @author liao
 * @date Jul 14, 2014
 */
package com.spider.gofetch.model;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

/**
 * @author liao
 *
 */
public abstract class GoFetchBaseTest extends TestCase {

	/**
	 * @return the station array
	 */
	protected String[] mockStationsForMap() {
		// this is the mock of vex
		String[] vex = new String[10];
		vex[0] = "A";
		vex[1] = "B";
		vex[2] = "C";
		vex[3] = "D";

		return vex;
	}
	
	/**
	 * @return mock 
	 */
	protected List<String> mockRoutesForMap() {
		List<String> edges = new ArrayList<String>();
		// for A
		edges.add("AB12");
		edges.add("AD19");

		// for B
		edges.add("BC5");

		// for C
		edges.add("CA5");

		// for D
		edges.add("DC7");

		return edges;
	}
}
