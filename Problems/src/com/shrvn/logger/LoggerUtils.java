/**
 * 
 */
package com.shrvn.logger;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

/**
 * @author shravan
 *
 */
public class LoggerUtils<T> {
	private Logger logger=null;
	public LoggerUtils(@SuppressWarnings("rawtypes") Class cls) {
		logger = Logger.getLogger(cls);
		configure();
	}
	public static void configure() {
		BasicConfigurator.configure();
	}
	public Logger getLogger() {
		return logger;
	}

	

}
