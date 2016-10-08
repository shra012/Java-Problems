/**
 * 
 */
package com.shrvn.recursion;

import java.io.File;

import org.apache.log4j.Logger;

import com.shrvn.logger.LoggerUtils;

/**
 * @author shravan
 *
 */
public class DiskUsage {
	@SuppressWarnings("rawtypes")
	static final Logger logger = new LoggerUtils(DiskUsage.class).getLogger();

	/***
	 * Main method to call diskUsage method which calculates 
	 * @param args
	 */
	public static void main(String[] args) {
		logger.debug("Inside main method");
		File root = new File("/Users/Hiruzen/introcs/Abstract"); 
		System.out.println(diskUsage(root)/1000 +"KB");
		logger.debug("Leaving main method");
	}

	public static long diskUsage(File root) {
		long total = root.length();
		if (root.isDirectory()) {
			for (String childname : root.list()) {
				File child = new File(root, childname);
				total += diskUsage(child);
			}
		}
		logger.debug(total + "\t" + root);
		return total;
	}
}
