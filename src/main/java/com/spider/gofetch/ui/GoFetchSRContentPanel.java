/**
 * filename: com.spider.gofetch.ui/GoFetchSRContentPanel.java
 * @author liao
 * @date Jul 11, 2014
 */
package com.spider.gofetch.ui;

import java.awt.Rectangle;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.spider.gofetch.model.IMap;

/**
 * @author liao
 *
 */
public class GoFetchSRContentPanel extends JPanel {
	
	/**
	 * fields
	 */
	private JComboBox startBox = new JComboBox();
	private JComboBox endBox = new JComboBox();
	
	private JLabel inputStartLabel = new JLabel();
	private JLabel inputEndLabel = new JLabel();
	private JLabel outputLabel = new JLabel();
	private JTextArea detailTxtArea = new JTextArea();
	
	private GoFetchShortestRoutePanel parentPanel;

	/**
	 * @param parentPanel the parent panel
	 */
	public GoFetchSRContentPanel(GoFetchShortestRoutePanel parentPanel) {
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
		inputStartLabel.setText("Input the start station: ");
		inputStartLabel.setBounds(new Rectangle(0, 40, 200, 20));
		startBox.setBounds(new Rectangle(210, 40, 50, 20));
		
		inputEndLabel.setText("Input the end station: ");
		inputEndLabel.setBounds(new Rectangle(0, 60, 200, 20));
		endBox.setBounds(new Rectangle(210, 60, 50, 20));
		
		outputLabel.setText("The shortest route is: ");
		outputLabel.setBounds(new Rectangle(0, 80, 200, 20));
		detailTxtArea.setBounds(new Rectangle(210, 80, 200, 40));
		detailTxtArea.setLineWrap(true); 
		
		this.add(inputStartLabel);
		this.add(startBox);
		this.add(inputEndLabel);
		this.add(endBox);
		this.add(outputLabel);
		this.add(detailTxtArea);
		
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

	public GoFetchShortestRoutePanel getParentPanel() {
		return parentPanel;
	}

	public JComboBox getStartBox() {
		return startBox;
	}

	public JComboBox getEndBox() {
		return endBox;
	}
	
	public JTextArea getDetailTxtArea() {
		return detailTxtArea;
	}

}
