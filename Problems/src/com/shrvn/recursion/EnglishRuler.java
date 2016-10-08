/**
 * 
 */
package com.shrvn.recursion;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

/**
 * @author shravan
 *
 */
public class EnglishRuler {
	static final Logger logger = Logger.getLogger(EnglishRuler.class);

	public static void configure() {
		BasicConfigurator.configure();
	}
	public static void main(String[] args) {
		configure();
		logger.debug("hello");
	}
	public static void drawRuler(int nInches,int majorLength) {

	}
	public static void drawLine(int tickLength) {
		drawLine(tickLength,1);
	} 
	public static void drawLine(int tickLength, int lable) {
		for (int i = 0; i < tickLength; i++) {

		}
	}
}
