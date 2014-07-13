/**
 * filename: com.spider.gofetch.ui/GoFetchMainFrame.java
 * @author liao
 * @date Jul 11, 2014
 */
package com.spider.gofetch.ui;

import java.awt.Rectangle;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.spider.gofetch.model.GoFetchMapFactory;
import com.spider.gofetch.model.IMap;
import com.spider.gofetch.util.GoFetchUtil;

/**
 * The main frame class in the application, which contains all other panels.
 * 
 * @author liao
 * 
 */
public class GoFetchMainFrame extends JFrame {

	// Variable Declarations
	private JPanel currentPanel = new JPanel();

	private GoFetchCalculateDistancePanel calculateDistancePanel = null;

	private GoFetchJourneyPlannerPanel journeyPlannerPanel = null;

	private GoFetchShortestRoutePanel shortestRoutePanel = null;

	/**
	 * the map instance for the application
	 */
	private IMap map;

	/**
	 * the default constructor
	 */
	public GoFetchMainFrame() {
		init();
	}

	/**
	 * 
	 */
	private void init() {
		// set size and bounds
		this.setSize(750, 660);
		this.setBounds(new Rectangle(0, 0, 750, 660));

		// set title and close operation
		setTitle("GoFetch Railways Assistant");
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		// set the menu bar
		GoFetchMenuBar menuBar = new GoFetchMenuBar(this);
		this.setJMenuBar(menuBar);

		// add the current panel
		this.getContentPane().add(currentPanel);

		// load the data and build the graph
		String[] vexs = GoFetchUtil.loadVexDataStorage();
		List<String> edges = GoFetchUtil.loadEdgesFromDataStorage();
		map = GoFetchMapFactory.getInstance().buildMap(vexs, edges);
	}

	public void showCalculateDistancePanel() {
		// Change the visibility of the Current Panel as FALSE i.e. to Hide the
		// Current Panel
		currentPanel.setVisible(false);

		// Remove the Current Panel from the Content Pane
		getContentPane().remove(currentPanel);
		if (calculateDistancePanel == null) {
			calculateDistancePanel = new GoFetchCalculateDistancePanel(this);
		}
		currentPanel = calculateDistancePanel;
		currentPanel.setVisible(true);
		this.getContentPane().add(currentPanel);
	}

	public void showShortestRoutePanel() {
		// Change the visibility of the Current Panel as FALSE i.e. to Hide the
		// Current Panel
		currentPanel.setVisible(false);

		// Remove the Current Panel from the Content Pane
		getContentPane().remove(currentPanel);
		if (shortestRoutePanel == null) {
			shortestRoutePanel = new GoFetchShortestRoutePanel(this);
		}
		currentPanel = shortestRoutePanel;
		currentPanel.setVisible(true);
		this.getContentPane().add(currentPanel);
	}

	public void showJourneyPlannerPanel() {
		// Change the visibility of the Current Panel as FALSE i.e. to Hide the
		// Current Panel
		currentPanel.setVisible(false);

		// Remove the Current Panel from the Content Pane
		getContentPane().remove(currentPanel);
		if (shortestRoutePanel == null) {
			journeyPlannerPanel = new GoFetchJourneyPlannerPanel(this);
		}
		currentPanel = journeyPlannerPanel;
		currentPanel.setVisible(true);
		this.getContentPane().add(currentPanel);
	}

	public IMap getMap() {
		return map;
	}

}
