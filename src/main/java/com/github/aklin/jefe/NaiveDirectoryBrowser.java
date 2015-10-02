package com.github.aklin.jefe;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.FileFilterUtils;

/**
 *
 */
public class NaiveDirectoryBrowser extends AbstractFilesystemBrowser {

	public NaiveDirectoryBrowser(final String path) {
		super(path);
	}

	@Override
	public List<File> getAvailableNodesAtPath() {
		final ArrayList<File> ret;
		ret = new ArrayList<>(FileUtils.listFiles(this.getAbsoluteFile(), FileFilterUtils.trueFileFilter(), null));

		return ret;
	}

	@Override
	public CharSequence getCanonicalPath() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
}
