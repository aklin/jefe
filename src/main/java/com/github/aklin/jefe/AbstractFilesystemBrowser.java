package com.github.aklin.jefe;

import com.google.common.collect.ImmutableList;
import java.io.File;
import java.text.DecimalFormat;
import org.apache.commons.io.FilenameUtils;

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
	 * Return a list of files and folders at the given path.
	 * @return
	 */
	public abstract ImmutableList<File> getAvailableNodesAtPath();

	public CharSequence getAbsolutePath() {
		return base.getAbsolutePath();
	}

	public File getAbsoluteFile() {
		return base.getAbsoluteFile();
	}

	public abstract CharSequence getCanonicalPath();

	/**
	 * Return the file extension.
	 * @param f
	 * @return
	 */
	public String getFileExtension(final File f) {
		return FilenameUtils.getExtension(f.getAbsolutePath());
	}

	/**
	 * Return the file name without its extension.
	 * @param f
	 * @return
	 */
	public String getFileBaseName(final File f) {
		return FilenameUtils.getBaseName(f.getAbsolutePath());
	}

	/**
	 *
	 * @param list
	 * @return
	 */
	public static String getFileListSizeString(final ImmutableList<File> list) {
		//get non-directories only
		return getBytesToSize(list.stream()
				.filter(f -> !f.isDirectory())
				.mapToLong(File::length)
				.sum());
	}

	public static String getBytesToSize(final double bytesize) {
		//code stolen from http://stackoverflow.com/a/20556766/2194007
		final String ret;
		double b = bytesize;
		double k = bytesize / 1024.0;
		double m = ((bytesize / 1024.0) / 1024.0);
		double g = (((bytesize / 1024.0) / 1024.0) / 1024.0);
		double t = ((((bytesize / 1024.0) / 1024.0) / 1024.0) / 1024.0);

		DecimalFormat dec = new DecimalFormat("0.00");

		if (t > 1) {
			ret = dec.format(t).concat(" TB");
		} else if (g > 1) {
			ret = dec.format(g).concat(" GB");
		} else if (m > 1) {
			ret = dec.format(m).concat(" MB");
		} else if (k > 1) {
			ret = dec.format(k).concat(" KB");
		} else {
			ret = dec.format(b).concat(" Bytes");
		}

		return ret;
	}

}
