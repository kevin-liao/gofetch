/**
 * filename: com.spider.gofetch.ui/GoFetchJPContentPanel.java
 * @author liao
 * @date Jul 11, 2014
 */
package com.spider.gofetch.ui;

import java.awt.Rectangle;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.spider.gofetch.model.IMap;

/**
 * The Journey Planner content panel to have input fields and output.
 * 
 * @author liao
 *
 */
public class GoFetchJPContentPanel extends JPanel {

	/**
	 * fields
	 */
	private JComboBox startBox = new JComboBox();
	private JComboBox endBox = new JComboBox();
	
	private JLabel inputStartLabel = new JLabel();
	private JLabel inputEndLabel = new JLabel();
	
	private JLabel inputStopsLabel = new JLabel();
	private JTextField stopsTxt = new JTextField();
	private JLabel outputLabel = new JLabel();
	private JTextField possiblitiesTxt = new JTextField();
	
	private GoFetchJourneyPlannerPanel parentPanel;

	/**
	 * @param parentPanel the parent panel
	 */
	public GoFetchJPContentPanel(GoFetchJourneyPlannerPanel parentPanel) {
		this.parentPanel = parentPanel;
		init();
	}

	/**
	 * initialize method
	 * 
	 */
	private void init() {
		this.setLayout(null);
		this.setSize(750, 150);

		// 
		inputStartLabel.setText("Select the start station: ");
		inputStartLabel.setBounds(new Rectangle(0, 40, 200, 20));
		startBox.setBounds(new Rectangle(210, 40, 50, 20));
		
		inputEndLabel.setText("Select the end station: ");
		inputEndLabel.setBounds(new Rectangle(0, 60, 200, 20));
		endBox.setBounds(new Rectangle(210, 60, 50, 20));
		
		inputStopsLabel.setText("Input the number of stops: ");
		inputStopsLabel.setBounds(new Rectangle(0, 80, 200, 20));
		stopsTxt.setBounds(new Rectangle(210, 80, 100, 20));
		
		outputLabel.setText("The possibilities of routes are: ");
		outputLabel.setBounds(new Rectangle(0, 100, 200, 20));
		possiblitiesTxt.setBounds(new Rectangle(210, 100, 200, 20));
		
		this.add(inputStartLabel);
		this.add(startBox);
		this.add(inputEndLabel);
		this.add(endBox);
		this.add(inputStopsLabel);
		this.add(stopsTxt);
		this.add(outputLabel);
		this.add(possiblitiesTxt);
		
		// initialize the items in combo box
		initComboBox();
	}
	
	private void initComboBox() {
		IMap map = this.getParentPanel().getMainFrame().getMap();
		if (map == null) {
			return;
		}
		String[] stations = map.getAllStations();
		if (stations != null) {
			int size = stations.length;
			for (int i = 0; i < size; i++) {
				startBox.addItem(stations[i]);
				endBox.addItem(stations[i]);
			}
		}
	}

	public JComboBox getStartBox() {
		return startBox;
	}

	public JComboBox getEndBox() {
		return endBox;
	}

	public JTextField getStopsTxt() {
		return stopsTxt;
	}

	public JTextField getPossiblitiesTxt() {
		return possiblitiesTxt;
	}

	public GoFetchJourneyPlannerPanel getParentPanel() {
		return parentPanel;
	}
}
