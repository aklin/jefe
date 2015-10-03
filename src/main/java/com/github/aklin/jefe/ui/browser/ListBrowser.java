package com.github.aklin.jefe.ui.browser;

import com.github.aklin.jefe.AbstractFilesystemBrowser;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import net.miginfocom.swing.MigLayout;

/**
 *
 */
public class ListBrowser extends AbstractBrowser {

	private final JList<File> list;
	private final DefaultListModel<File> model;

	public ListBrowser(final AbstractAction itemActive,
			final AbstractAction itemHover,
			final AbstractFilesystemBrowser browser) {
		super(itemActive, itemHover, browser, Collections.EMPTY_LIST);
		this.setLayout(new MigLayout("gapy 0"));
		model = new DefaultListModel<>();
		list = new JList<>(model);
		populateModel();
		this.add(new JScrollPane(list), "push,grow");
	}

	@Override
	public void refreshBrowser() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	private void populateModel() {
		final List<File> l = getBrowser().getAvailableNodesAtPath();

		for (final File f : l)
			model.addElement(f);
		list.updateUI();
	}

	@Override
	public ImmutableList<File> getAvailableNodes() {
		final Builder<File> b = ImmutableList.builder();

		for (int i = 0; i < model.size(); i++)
			b.add(model.get(i));

		return b.build();
	}

	@Override
	public ImmutableList<File> getSelectedNodes() {
		final Builder<File> b = ImmutableList.builder();
		return b.addAll(list.getSelectedValuesList()).build();
	}

	@Override
	public boolean hasSelection() {
		return !list.isSelectionEmpty();
	}
}
