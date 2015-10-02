package com.github.aklin.jefe.ui;

import com.github.aklin.jefe.NaiveDirectoryBrowser;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JFrame;

/**
 *
 */
public class Window extends JFrame {
	
	private static final AbstractAction emptyAction;
	
	static {
		emptyAction = new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		};
	}
	
	public Window() {
		this.add(new ListBrowser(emptyAction, emptyAction, new NaiveDirectoryBrowser("")));
		setSize(600, 480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
