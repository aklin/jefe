package com.github.aklin.jefe;

import java.io.File;
import java.util.List;

/**
 *
 */
public abstract class AbstractFilesystemBrowser {

	private final File base;

	public AbstractFilesystemBrowser(final String base) {
		this(base == null ? null : new File(base));
	}

	public AbstractFilesystemBrowser(final File base) {
		if (base == null)
			throw new IllegalArgumentException("'base' cannot be null");
		this.base = base;
	}

	/**
	 * Return a list of files and folders at the given path. The list may be influenced by
	 * user preferences, which this method is expected to take into account.
	 * @return
	 */
	public abstract List<File> getAvailableNodesAtPath();

	public CharSequence getAbsolutePath(){
		return base.getAbsolutePath();
	}
	
	public File getAbsoluteFile(){
		return base.getAbsoluteFile();
	}

	public abstract CharSequence getCanonicalPath();
}
