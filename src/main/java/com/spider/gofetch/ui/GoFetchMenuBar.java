/**
 * filename: com.spider.gofetch.ui/GoFetchMenu.java
 * @author liao
 * @date Jul 11, 2014
 */
package com.spider.gofetch.ui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * @author liao
 * 
 */
public class GoFetchMenuBar extends JMenuBar {

	private GoFetchMainFrame mainFrame;

	private JDialog aboutDialog;
	
	private JDialog adminDialog;

	/**
	 * 
	 */
	public GoFetchMenuBar(GoFetchMainFrame mainFrame) {
		this.mainFrame = mainFrame;
		init();
	}

	private void init() {
		// File Menu
		JMenu fileMenu = new JMenu("File");
		JMenuItem exitMenuItem = new JMenuItem("Exit", KeyEvent.VK_E);
		fileMenu.add(exitMenuItem);

		// Tool menu
		JMenu toolMenu = new JMenu("Tool");
		JMenuItem calculateDistanceMenuItem = new JMenuItem(
				"Calculate Distance", KeyEvent.VK_C);
		JMenuItem journeyPlannerMenuItem = new JMenuItem("Journey Planner",
				KeyEvent.VK_J);
		JMenuItem shortestRouteMenuItem = new JMenuItem("Shortest Route",
				KeyEvent.VK_S);
		toolMenu.add(calculateDistanceMenuItem);
		toolMenu.add(journeyPlannerMenuItem);
		toolMenu.add(shortestRouteMenuItem);

		// Map Admin menu
		JMenu configMenu = new JMenu("Map Admin");
		JMenuItem addNewStationMenuItem = new JMenuItem("Add New Station",
				KeyEvent.VK_A);
		JMenuItem updateRouteItem = new JMenuItem("Update Route", KeyEvent.VK_U);
		JMenuItem reloadMenuItem = new JMenuItem("Reload Map", KeyEvent.VK_R);
		configMenu.add(addNewStationMenuItem);
		configMenu.add(updateRouteItem);
		configMenu.add(reloadMenuItem);

		// Help Menu
		JMenu helpMenu = new JMenu("Help");
		JMenuItem helpMenuItem = new JMenuItem("Help", KeyEvent.VK_H);
		JMenuItem aboutMenuItem = new JMenuItem("About", KeyEvent.VK_A);
		helpMenu.add(helpMenuItem);
		helpMenu.add(aboutMenuItem);

		// Add all menus in menu bar
		this.add(fileMenu);
		this.add(toolMenu);
		this.add(configMenu);
		this.add(helpMenu);

		aboutDialog = new JDialog();
		initAboutDialog();
		
		adminDialog = new JDialog();

		// add the action listener to the "Calculate Distance" menu item
		calculateDistanceMenuItem.addActionListener(new ActionListener() {
			//
			public void actionPerformed(ActionEvent e) {
				mainFrame.showCalculateDistancePanel();
			}
		});
		
		// add the action listener to the "Calculate Distance" menu item
		journeyPlannerMenuItem.addActionListener(new ActionListener() {
			//
			public void actionPerformed(ActionEvent e) {
				mainFrame.showJourneyPlannerPanel();
			}
		});

		// add the action listener to the "Calculate Distance" menu item
		shortestRouteMenuItem.addActionListener(new ActionListener() {
			//
			public void actionPerformed(ActionEvent e) {
				mainFrame.showShortestRoutePanel();
			}
		});

		// add the action listener to the exit menu item
		exitMenuItem.addActionListener(new ActionListener() {
			//
			public void actionPerformed(ActionEvent e) {
				// dispose();
				System.exit(0);
			}
		});

		// add the action listener to the about menu item
		aboutMenuItem.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				aboutDialog.show();
			}

		});
		
		// add the action listener to the admin menu -> add new station menu item
		addNewStationMenuItem.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				cleanAdminDialog();
				initAdminDialog("Not implemented yet. You could add a new station in future.");
				adminDialog.show();
			}

		});
		
		// add the action listener to the admin menu -> update route menu item
		updateRouteItem.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				cleanAdminDialog();
				initAdminDialog("Not implemented yet. You could update a specific route/path in future.");
				adminDialog.show();
			}

		});

		
	}

	private void initAboutDialog() {
		aboutDialog.setTitle("About");
		Container con = aboutDialog.getContentPane();
		JLabel nameLabel = new JLabel("Name: GoFetch Railways Assistant");
		JLabel versionLabel = new JLabel("Version: 1.0");
		JLabel copyrightLabel = new JLabel("Copyright @ 2014 Kevin Liao");
		con.add(nameLabel, BorderLayout.NORTH);
		con.add(versionLabel, BorderLayout.CENTER);
		con.add(copyrightLabel, BorderLayout.SOUTH);
		aboutDialog.setSize(450, 225);
		aboutDialog.setLocation(300, 300);
	}
	
	private void initAdminDialog(String text) {
		adminDialog.setTitle("Map Admin");
		Container con = adminDialog.getContentPane();
		JLabel label = new JLabel(text);
		con.add(label, BorderLayout.CENTER);
		adminDialog.setSize(450, 225);
		adminDialog.setLocation(300, 300);
	}
	
	private void cleanAdminDialog(){
		adminDialog.getContentPane().removeAll();
	}
}
