/**
 * filename: com.spider.gofetch.ui/GoFetchCalculateDistancePanel.java
 * @author liao
 * @date Jul 11, 2014
 */
package com.spider.gofetch.ui;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.spider.gofetch.util.Constants;
import com.spider.gofetch.util.GoFetchUtil;

/**
 * The Calculate Distance Panel in UI.
 * 
 * @author liao
 *
 */
public class GoFetchCalculateDistancePanel extends JPanel {
	
	private GoFetchMainFrame mainFrame;
	private GoFetchMapPanel mapPanel = new GoFetchMapPanel();
	private GoFetchCDContentPanel contentPanel;
	private GoFetchTopHeaderPanel topHeaderPanel = new GoFetchTopHeaderPanel(Constants.CD_TITLE_DESC);
	
	/**
	 * 
	 * @param mainFrame
	 */
	public GoFetchCalculateDistancePanel(GoFetchMainFrame mainFrame)
	{
		this.mainFrame = mainFrame;
		contentPanel = new GoFetchCDContentPanel(this);
		init();
	}
	
	private void init()
	{
		this.setLayout(null);
		this.setBounds(new Rectangle(0, 0, 750, 660));

		// Setting Top Header panel properties
		topHeaderPanel.setBounds(new Rectangle(0, 0, 750, 20));
		this.add(topHeaderPanel);
		
		// Setting the Input/Output panel
		this.add(contentPanel);
		
		// Adding buttons to content panel
		JButton calculateButton = new javax.swing.JButton();
		calculateButton.setText(Constants.CD_BTN_CALCULATE);
		calculateButton.setBounds(new Rectangle(100, 105, 100, 20));
		contentPanel.add(calculateButton);
        
		// adds the button action handler
		calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	calculateButtonActionPerformed(evt);
            }
        });
		
		JButton resetButton = new javax.swing.JButton();
		resetButton.setText("Reset");
		resetButton.setBounds(new Rectangle(210, 105, 100, 20));
		contentPanel.add(resetButton);
        
		// adds the button action handler
		resetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	resetButtonActionPerformed(evt);
            }
        });

		// Setting map panel properties
		mapPanel.setBounds(new Rectangle(0, 110, 750, 500));
		mapPanel.setLayout(null);
		this.add(mapPanel, null);
	}
	
	/**
	 * 
	 * @param evt
	 */
	private void calculateButtonActionPerformed(ActionEvent evt)
	{
		String route = null;
		if (!contentPanel.useRouteText())
		{
			// get the route from combo box
			route = contentPanel.getRouteFromComboBox();
		}
		else {
			// get the route from text field
			route = contentPanel.getRouteTxt().getText();
		}
		
		// calculate the distance of the route
		String distance = GoFetchUtil.calculateDistanceForRoute(mainFrame.getMap(), route);
		contentPanel.getDistanceTxt().setText(distance);
	}
	
	private void resetButtonActionPerformed(ActionEvent evt)
	{
		// do something here.
		this.contentPanel.resetAllComboBoxes();
		this.contentPanel.getRouteTxt().setText("");
		this.contentPanel.getDistanceTxt().setText("");
	}

	/**
	 * Get the main frame
	 * 
	 * @return the main frame
	 */
	public GoFetchMainFrame getMainFrame() {
		return this.mainFrame;
	}
}
