package com.github.aklin.jefe.ui;

import static com.github.aklin.jefe.AbstractFilesystemBrowser.getFileListSizeString;
import com.github.aklin.jefe.ui.browser.ListBrowser;
import com.google.common.collect.ImmutableList;
import java.io.File;
import javax.swing.JLabel;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;

/**
 *
 */
public final class BottomPanel extends JPanel {

	private final ListBrowser browser;
	private final JLabel sizeLabel;
	private final JLabel sizeValue;

	public BottomPanel(final ListBrowser activeBrowser) {
		if (activeBrowser == null)
			throw new IllegalArgumentException();

		this.setLayout(new MigLayout());
		this.browser = activeBrowser;

		sizeLabel = new JLabel();
		sizeValue = new JLabel();
		refreshLabels();

		this.add(sizeLabel);
		this.add(sizeValue);
	}

	public void refreshLabels() {
		final ImmutableList<File> sel;

		if (browser.hasSelection()) {
			//no user selection, report size of all files
			sel = browser.getSelectedNodes();
			sizeLabel.setText("Folder Size: ");
		} else {
			sel = browser.getAvailableNodes();
			sizeLabel.setText("Selection Size: ");
		}

		sizeValue.setText(getFileListSizeString(sel));
	}
}
