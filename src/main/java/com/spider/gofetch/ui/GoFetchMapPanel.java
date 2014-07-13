/**
 * filename: com.spider.gofetch.ui/GoFetchMapPanel.java
 * @author liao
 * @date Jul 11, 2014
 */
package com.spider.gofetch.ui;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * The Map Panel in UI part, which has one label and the image
 * to show the current map.
 * 
 * @author liao
 * 
 */
public class GoFetchMapPanel extends JPanel {
	
	private BufferedImage image;

	/**
	 * Default Constructor for this class
	 * 
	 */
	public GoFetchMapPanel() {
		
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/map.jpg"));
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		init();
	}
	
	@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 110, null);
    }

	private void init() {
		this.setLayout(null);
		this.setSize(750, 400);
		// add the label
		JLabel label = new JLabel("The Current Map: ");
		label.setBounds(new Rectangle(0, 90, 100, 20));
		this.add(label); 
	}

}
