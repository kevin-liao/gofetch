/**
 * 
 */
package com.spider.gofetch.ui;

import java.awt.FlowLayout;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * 
 * @author liao
 * 
 */
public class GoFetchButtonPanel extends JPanel {

	private Map<String, JButton> buttonList = new HashMap<String, JButton>();

	/**
	 * Default Constructor for this class
	 * 
	 */
	public GoFetchButtonPanel() {
		init();
	}

	/**
	 * 
	 * Method to add a Button
	 * 
	 * @param buttonName
	 *            - Name of the Button to be added
	 * @param buttonType
	 *            - Type of the Button to be added
	 * @return - Button object
	 */
	public JButton addButton(String buttonName, int buttonType) {
		return addButton(buttonName, buttonType, 65);
	}

	/**
	 * 
	 * Method to add Button
	 * 
	 * @param buttonName
	 *            - Name of the Button
	 * @param buttonType
	 *            - Type of the Button
	 * @param width
	 *            - Width for the Button
	 * @return - Button object
	 */
	public JButton addButton(String buttonName, int buttonType, int width) {
		JButton button = null;
		int borderWidth = 3;

		if (!buttonList.containsKey(buttonName)) {
			button = new JButton();// buttonList.get(buttonName);
			button.setSize(width + borderWidth, 18);
			button.setText(buttonName);

			this.add(button);
			buttonList.put(buttonName, button);
		}

		return button;
	}

	/**
	 * 
	 * Method to enable / disable a specific Button
	 * 
	 * @param buttonName
	 *            - Name of the Button to be enabled / disabled
	 * @param isEnabledButton
	 *            - Flag to show whether to enable or disable the button
	 * @throws GraderException
	 */
	public void setEnable(String buttonName, boolean isEnabledButton) {
		JButton button = null;
		if (buttonList.containsKey(buttonName)) {
			button = (JButton) buttonList.get(buttonName);
			button.setEnabled(isEnabledButton);
		}
	}

	/**
	 * 
	 * Method to get Button object using its Name
	 * 
	 * @param buttonName
	 *            - Name of the Button to obtain its object
	 * @return - Button object returned by the method
	 */
	public JButton getButton(String buttonName) {
		JButton button = null;
		if (buttonList.containsKey(buttonName)) {
			button = (JButton) buttonList.get(buttonName);
		}
		return button;
	}

	/**
	 * 
	 * Method to remove Button from the Panel
	 * 
	 * @param buttonName
	 *            - Name of the button to be removed
	 * @throws GraderException
	 */
	public void removeButton(String buttonName) {
		// Untested method.
		JButton button = null;

		if (buttonList.containsKey(buttonName)) {
			button = (JButton) buttonList.get(buttonName);
			this.remove(button);
			buttonList.remove(buttonName);
		}
	}

	/**
	 * 
	 * Method to set layout and other GUI related properties of the Button panel
	 * 
	 * @throws Exception
	 */
	private void init() {
		FlowLayout layout = new FlowLayout();
		layout.setAlignment(FlowLayout.CENTER);
		layout.setVgap(10);
		layout.setHgap(5);
		this.setLayout(layout);
	}

}
