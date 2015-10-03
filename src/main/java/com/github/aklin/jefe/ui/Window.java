package com.github.aklin.jefe.ui;

import com.github.aklin.jefe.NaiveDirectoryBrowser;
import com.github.aklin.jefe.ui.browser.AbstractBrowser;
import com.github.aklin.jefe.ui.browser.TableBrowser;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;

/**
 *
 */
public class Window extends JFrame {

	private static final AbstractAction emptyAction;

	private final AbstractBrowser browser;
	private final BottomPanel bottom;

	static {
		emptyAction = new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		};
	}

	public Window() {
		this.setLayout(new MigLayout("gapy 0"));

		browser = new TableBrowser(emptyAction, emptyAction, new NaiveDirectoryBrowser(""));
		bottom = new BottomPanel(browser);

		this.add(browser, "push,grow");
		this.add(bottom, "dock south");

		setSize(600, 480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
