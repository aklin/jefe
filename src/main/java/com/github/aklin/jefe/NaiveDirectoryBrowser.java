package com.github.aklin.jefe;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.io.File;
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
	public ImmutableList<File> getAvailableNodesAtPath() {
		final Builder<File> b = ImmutableList.builder();

		return b.addAll(FileUtils.listFiles(
				this.getAbsoluteFile(),
				FileFilterUtils.trueFileFilter(),
				null))
				.build();
	}

	@Override
	public CharSequence getCanonicalPath() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
}
