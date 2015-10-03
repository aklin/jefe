package com.github.aklin.jefe.ui.browser;

import com.github.aklin.jefe.AbstractFilesystemBrowser;
import static com.github.aklin.jefe.AbstractFilesystemBrowser.getBytesToSize;
import com.google.common.collect.ImmutableList;
import java.io.File;
import javax.swing.AbstractAction;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import net.miginfocom.swing.MigLayout;

/**
 *
 */
public final class TableBrowser extends AbstractBrowser {

	private final JTable tbl;
	private final DefaultTableModel model;

	public TableBrowser(final AbstractAction onItemSelected,
			final AbstractAction onItemHover,
			final AbstractFilesystemBrowser browser) {
		super(onItemSelected, onItemHover, browser, null);

		setLayout(new MigLayout());

		model = new DefaultTableModel();
		tbl = new JTable(model);

		model.addColumn("Type");
		model.addColumn("Name");
		model.addColumn("Size");

		tbl.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
		tbl.getColumnModel().getColumn(0).setMaxWidth(135);
		tbl.setRowHeight((tbl.getRowHeight()*3)/2);
		populate();

		this.add(new JScrollPane(tbl), "push,grow");
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
		return ImmutableList.of();
	}

	@Override
	public boolean hasSelection() {
		return tbl.getSelectedRowCount() > 0;
	}
}
