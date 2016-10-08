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
public class Power {
	@SuppressWarnings("rawtypes")
	static final Logger logger = new LoggerUtils(Power.class).getLogger();

	/**
	 * @param Driver method to test the pow function 
	 * and logger is used to test speed of recursion
	 * btw power and pow methods
	 */
	public static void main(String[] args) {
		logger.debug("Inside main method");
		System.out.println(power(2,13));
		logger.debug("pow method is finished");
		System.out.println(pow(2,13));
		logger.debug("Leaving main method");

	}

	/**
	 * Computes the value of x raised to the nth power,
	 *  for nonnegative integer n.
	 * @return
	 */
	public static double power(double x, int n) {
		if (n == 0)
			return 1;
		else
			return x * power(x, n - 1);
	}

	/**
	 * 
	 * Computes the value of x raised to the nth power,
	 * for nonnegative integer n.
	 * @return
	 */
	public static double pow(double x, int n) {
		if (n == 0)
			return 1;
		else {
			double partial = pow(x, n / 2);
			double result = partial * partial;
			if (n % 2 == 1)
				result *= x;
			return result;
		}
	}

}
