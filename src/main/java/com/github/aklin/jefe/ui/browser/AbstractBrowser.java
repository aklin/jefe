package com.github.aklin.jefe.ui.browser;

import com.github.aklin.jefe.AbstractFilesystemBrowser;
import com.google.common.collect.ImmutableList;
import java.io.File;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.JPanel;

/**
 *
 */
public abstract class AbstractBrowser extends JPanel {

	private final AbstractFilesystemBrowser browser;

	/**
	 *
	 * @param onItemSelected Perform action on selection
	 * @param onItemHover Perform action on mouse hover
	 * @param fs
	 * @param preselected Items to select at the beginning
	 */
	public AbstractBrowser(final AbstractAction onItemSelected,
			final AbstractAction onItemHover,
			final AbstractFilesystemBrowser fs,
			final List<File> preselected) {
		if (fs == null)
			throw new IllegalArgumentException("'browser' cannot be null");
		if (onItemSelected == null)
			throw new IllegalArgumentException("'itemSelectedAction' cannot be null");

		this.browser = fs;
	}

	public abstract void refreshBrowser();

	public final AbstractFilesystemBrowser getBrowser() {
		return browser;
	}

	/**
	 * Get available nav nodes at this path. The list may be influenced by user
	 * preferences, which this method is expected to take into account.
	 * @return
	 */
	public ImmutableList<File> getAvailableNodes() {
		return browser.getAvailableNodesAtPath();
	}

	/**
	 * Get those nodes selected by the user.
	 * @return
	 */
	public abstract ImmutableList<File> getSelectedNodes();

	/**
	 * Check if any items are selected. Returns true if so, false otherwise.
	 * @return
	 */
	public abstract boolean hasSelection();
}
