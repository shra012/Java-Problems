/**
 * 
 */
package com.shrvn.recursion;

import org.apache.log4j.Logger;

import com.shrvn.logger.LoggerUtils;

/**
 * @author shravan
 *
 */
public class EnglishRuler {
	@SuppressWarnings("rawtypes")
	static final Logger logger = new LoggerUtils(EnglishRuler.class).getLogger();

	

	public static void main(String[] args) {
		logger.debug("Inside main method");
		drawRuler(2,4);
		logger.debug("Leaving main method");
	}

	public static void drawRuler(int nInches, int majorLength) {
		drawLine(majorLength, 0);
		for (int j = 1; j <= nInches; j++) {
			drawInterval(majorLength - 1);
			drawLine(majorLength, j);
		}
	}

	public static void drawInterval(int centralLength) {
		if (centralLength >= 1) {
			drawInterval(centralLength - 1);
			drawLine(centralLength);
			drawInterval(centralLength - 1);
		}
	}

	public static void drawLine(int tickLength, int lable) {
		for (int i = 0; i < tickLength; i++){
			System.out.print("-");
		}
		if (lable >= 0) {
			System.out.print(" " + lable);
		}
		System.out.println();
	}

	public static void drawLine(int tickLength) {
		drawLine(tickLength, -1);
	}

}
