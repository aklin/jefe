package com.github.aklin.jefe.ui;

import com.github.aklin.jefe.AbstractFilesystemBrowser;
import java.io.File;
import java.util.Collections;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JScrollPane;

/**
 *
 */
public class ListBrowser extends WindowItemBrowser {

	private final JList<File> list;
	private final DefaultListModel<File> model;

	public ListBrowser(final AbstractAction itemActive,
			final AbstractAction itemHover,
			final AbstractFilesystemBrowser browser) {
		super(itemActive, itemHover, browser, Collections.EMPTY_LIST);
		model = new DefaultListModel<>();
		list = new JList<>(model);
		populateModel();
		this.add(new JScrollPane(list));
	}

	@Override
	public void refreshBrowser() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	private void populateModel() {
		final List<File> l = getBrowser().getAvailableNodesAtPath();

		for (File f : l)
			model.addElement(f);
		list.updateUI();
	}
}
