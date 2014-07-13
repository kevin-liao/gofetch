/**
 * filename: com.spider.gofetch.ui/GoFetchCDContentPanel.java
 * @author liao
 * @date Jul 11, 2014
 */
package com.spider.gofetch.ui;

import java.awt.Rectangle;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.spider.gofetch.model.IMap;
import com.spider.gofetch.util.Constants;

/**
 * The Calculate Distance(CD) Content panel to have input fields and output text.
 * 
 * @author liao
 * 
 */
public class GoFetchCDContentPanel extends JPanel {

	/**
	 * fields
	 */
	private JComboBox firstStationBox = new JComboBox();
	private JComboBox secondStationBox = new JComboBox();
	private JComboBox thirdStationBox = new JComboBox();

	private JLabel firstDashLabel = new JLabel(Constants.CD_LABEL_DELIMITER);
	private JLabel secondDashLabel = new JLabel(Constants.CD_LABEL_DELIMITER);

	private JCheckBox textRouteCheckBox = new JCheckBox();
	private JLabel orLabel = new JLabel(" or input the text delimited by '-' ");

	private JLabel inputLabel = new JLabel();
	private JTextField routeTxt = new JTextField();
	private JLabel outputLabel = new JLabel();
	private JTextField distanceTxt = new JTextField();

	private GoFetchCalculateDistancePanel parentPanel;

	/**
	 * 
	 */
	public GoFetchCDContentPanel(GoFetchCalculateDistancePanel parentPanel) {
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
		inputLabel.setText(Constants.CD_LABEL_INPUT_ROUTE);
		inputLabel.setBounds(new Rectangle(0, 40, 200, 20));

		firstStationBox.setBounds(new Rectangle(210, 40, 50, 20));
		secondStationBox.setBounds(new Rectangle(280, 40, 50, 20));
		thirdStationBox.setBounds(new Rectangle(350, 40, 50, 20));

		firstDashLabel.setBounds(new Rectangle(260, 40, 20, 20));
		secondDashLabel.setBounds(new Rectangle(330, 40, 20, 20));

		textRouteCheckBox.setBounds(new Rectangle(10, 60, 20, 20));
		orLabel.setBounds(new Rectangle(30, 60, 200, 20));

		routeTxt.setBounds(new Rectangle(210, 60, 100, 20));

		outputLabel.setText(Constants.CD_LABEL_DISTANCE_OF_ROUTE);
		outputLabel.setBounds(new Rectangle(0, 80, 200, 20));
		distanceTxt.setBounds(new Rectangle(210, 80, 300, 20));

		// init the items in combobox
		initComboBox();

		// add all components for this panel
		this.add(inputLabel);
		this.add(firstStationBox);
		this.add(firstDashLabel);
		this.add(secondStationBox);
		this.add(secondDashLabel);
		this.add(thirdStationBox);
		this.add(textRouteCheckBox);
		this.add(orLabel);
		this.add(routeTxt);
		this.add(outputLabel);
		this.add(distanceTxt);

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
				firstStationBox.addItem(stations[i]);
				secondStationBox.addItem(stations[i]);
				thirdStationBox.addItem(stations[i]);
			}
		}

	}

	public GoFetchCalculateDistancePanel getParentPanel() {
		return parentPanel;
	}

	public void setParentPanel(GoFetchCalculateDistancePanel parentPanel) {
		this.parentPanel = parentPanel;
	}

	public JLabel getInputLabel() {
		return inputLabel;
	}

	public JTextField getRouteTxt() {
		return routeTxt;
	}

	public JLabel getOutputLabel() {
		return outputLabel;
	}

	public JTextField getDistanceTxt() {
		return distanceTxt;
	}
	
	/**
	 * @return the flag to indicate which route input option is used
	 */
	public boolean useRouteText()
	{
		return textRouteCheckBox.isSelected();
	}
	
	/**
	 * This function is to get the route from those three combo boxes
	 * 
	 * @return the string from three combo boxes
	 */
	public String getRouteFromComboBox()
	{
		StringBuffer sb = new StringBuffer();
		sb.append(firstStationBox.getSelectedItem()).append("-")
				.append(secondStationBox.getSelectedItem()).append("-")
				.append(thirdStationBox.getSelectedItem());
		return sb.toString();
	}
	
	public void resetAllComboBoxes()
	{
		firstStationBox.setSelectedItem(null);
		secondStationBox.setSelectedItem(null);
		thirdStationBox.setSelectedItem(null);
	}

}
