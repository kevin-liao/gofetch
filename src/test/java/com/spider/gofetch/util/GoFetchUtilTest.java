/**
 * filename: com.spider.gofetch.util/GoFetchUtilTest.java
 * @author liao
 * @date Jul 11, 2014
 */
package com.spider.gofetch.util;

import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Test;

/**
 * @author liao
 *
 */
public class GoFetchUtilTest {

	@Test
	public void testbuildDetailForJourneyPlannerResult() {
		
		List<List<String>> paths = null;
		String distance = GoFetchUtil.buildDetailForJourneyPlannerResult(paths);
		assertNull(distance);
	}
}
