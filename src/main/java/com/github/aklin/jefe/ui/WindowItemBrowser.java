package com.github.aklin.jefe.ui;

import com.github.aklin.jefe.AbstractFilesystemBrowser;
import java.io.File;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.JPanel;

/**
 *
 */
public abstract class WindowItemBrowser extends JPanel {

	private final AbstractFilesystemBrowser browser;

	/**
	 *
	 * @param itemActive Perform action on selection
	 * @param itemHover Perform action on mouse hover
	 * @param browser
	 * @param selected Pre-selected items
	 */
	public WindowItemBrowser(final AbstractAction itemActive,
			final AbstractAction itemHover,
			final AbstractFilesystemBrowser browser,
			final List<File> selected) {
		if (browser == null)
			throw new IllegalArgumentException("'browser' cannot be null");
		if (itemActive == null)
			throw new IllegalArgumentException("'itemSelectedAction' cannot be null");

		this.browser = browser;
	}

	public abstract void refreshBrowser();

	protected final AbstractFilesystemBrowser getBrowser() {
		return browser;
	}
}
