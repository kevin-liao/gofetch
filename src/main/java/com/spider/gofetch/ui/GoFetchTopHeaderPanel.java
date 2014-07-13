/**
 * filename: com.spider.gofetch.ui/GoFetchTopHeaderPanel
 * @author liao
 * @date Jul 11, 2014
 */
package com.spider.gofetch.ui;

import java.awt.Rectangle;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Top Header panel to be used across nearly all use cases.
 * 
 * @author liao
 * 
 */
public class GoFetchTopHeaderPanel extends JPanel {
	
	private String name;
	private JLabel label = new JLabel();
	
	/**
	 * Default Constructor
	 */
	public GoFetchTopHeaderPanel() {
		init();
	}
	
	/**
	 * Default Constructor
	 */
	public GoFetchTopHeaderPanel(String name) {
		this.name = name;
		init();
	}

	/**
	 * jbInit method for adding GUI components and their properties
	 * 
	 * @throws Exception
	 */
	private void init() {
		this.setLayout(null);
		this.setSize(750, 20);
		
		label.setText(this.name);
		label.setBounds(new Rectangle(0, 0, 750, 20));
		this.add(label);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

}
