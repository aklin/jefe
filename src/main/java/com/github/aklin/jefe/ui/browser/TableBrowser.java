package com.github.aklin.jefe.ui.browser;

import com.github.aklin.jefe.AbstractFilesystemBrowser;
import static com.github.aklin.jefe.AbstractFilesystemBrowser.getBytesToSize;
import com.github.aklin.jefe.NaiveDirectoryBrowser;
import com.google.common.collect.ImmutableList;
import java.io.File;
import java.util.Vector;
import javax.swing.AbstractAction;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 */
public class TableBrowser extends AbstractBrowser {

	private final JTable tbl;
	private final DefaultTableModel model;

	public TableBrowser(final AbstractAction onItemSelected,
			final AbstractAction onItemHover,
			final AbstractFilesystemBrowser browser) {
		super(onItemSelected, onItemHover, browser, null);

		model = new DefaultTableModel();
		tbl = new JTable(model);

		model.addColumn("ext");
		model.addColumn("Name");
		model.addColumn("Size");
	}

	private void populate() {
		final ImmutableList<File> l;
		l = getAvailableNodes();

		l.stream().forEach(f -> {
			model.addRow(new String[]{
				getBrowser().getFileExtension(f),
				getBrowser().getFileBaseName(f),
				getBytesToSize(f.length())});
		});

	}

	@Override
	public void refreshBrowser() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public ImmutableList<File> getSelectedNodes() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public boolean hasSelection() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
}
