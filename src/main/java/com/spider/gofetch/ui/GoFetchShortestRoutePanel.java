/**
 * filename: com.spider.gofetch.ui/GoFetchShortestRoutePanel.java
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

/**
 * The Shorted Route Panel in UI.
 * 
 * @author liao
 *
 */
public class GoFetchShortestRoutePanel extends JPanel {
	
	private GoFetchMainFrame mainFrame;
	private GoFetchMapPanel mapPanel = new GoFetchMapPanel();
	private GoFetchSRContentPanel contentPanel;
	private GoFetchTopHeaderPanel topHeaderPanel = new GoFetchTopHeaderPanel(Constants.SR_TITLE_DESC);

	/**
	 * 
	 * @param mainFrame
	 */
	public GoFetchShortestRoutePanel(GoFetchMainFrame mainFrame)
	{
		this.mainFrame = mainFrame;
		contentPanel = new GoFetchSRContentPanel(this);
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
		JButton checkButton = new javax.swing.JButton();
		checkButton.setText("Check");
		checkButton.setBounds(new Rectangle(100, 125, 100, 20));
		contentPanel.add(checkButton);
        
		// adds the button action handler
		checkButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	checkButtonActionPerformed(evt);
            }
        });
		
		JButton resetButton = new javax.swing.JButton();
		resetButton.setText("Reset");
		resetButton.setBounds(new Rectangle(210, 125, 100, 20));
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
	private void checkButtonActionPerformed(ActionEvent evt)
	{
		// get the start and end station
		String from = (String)contentPanel.getStartBox().getSelectedItem();
		String to = (String)contentPanel.getEndBox().getSelectedItem();
		// find the shortest route and show it
		String detail = mainFrame.getController().findShortestRoute(from, to);
		contentPanel.getDetailTxtArea().setText(detail);
	}
	
	private void resetButtonActionPerformed(ActionEvent evt)
	{
		// do something here.
		contentPanel.getStartBox().setSelectedItem(null);
		contentPanel.getEndBox().setSelectedItem(null);
		contentPanel.getDetailTxtArea().setText("");
	}

	public GoFetchMainFrame getMainFrame() {
		return mainFrame;
	}

}
