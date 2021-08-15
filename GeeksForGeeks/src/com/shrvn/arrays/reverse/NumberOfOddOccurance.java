/**
 * 
 */
package com.shrvn.arrays.reverse;

/**
 * @author shravan
 *
 */
public class NumberOfOddOccurance {

	/**
	 * I/P = [1, 2, 3, 2, 3, 1, 3]
	   O/P = 3
	 */
	public static void main(String[] args) {
	int a[]  = 	{1, 2, 3, 2, 3, 1, 3};
	int result=0;
	for (int i = 0; i < a.length; i++) {
		result^=a[i];
	}
	System.out.println(result);

	}

}
