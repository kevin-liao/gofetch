/**
 * filename: com.spider.gofetch.main/GoFetchApplication.java
 * @author liao
 * @date Jul 11, 2014
 */
package com.spider.gofetch.main;

import com.spider.gofetch.ui.GoFetchMainFrame;

/**
 * This class is the portal of the application. 
 * 
 * @author liao
 *
 */
public class GoFetchApplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 
		java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GoFetchMainFrame().setVisible(true);
            }
        });
	}

}
