/**
 * 
 */
package com.shrvn.recursion;

/**
 * @author shravan
 *
 */
public class BinarySum {

	/**
	 * Driver method to call the binarySum method
	 */
	public static void main(String[] args) {
		int data[] = {2,3,5,6,7,8,1,2,3,0,4};
		int sum = binarySum(data,0,data.length-1);
		System.out.println(sum);

	}

	/**
	 * O(lognn) Space is used which is better than iterative O(n). 
	 * @param Array for which sum is to be calculated
	 * @param low is lower the index of sub-array[] to be added
	 * @param high is the higher index of sub-array[] to be added 
	 * @return the sum of sub-array data[low] through data[high] inclusive.
	 */
	public static int binarySum(int[] data, int low, int high) {
		if (low > high)
			return 0;
		else if (low == high)
			return data[low];
		else {
			int mid = (low + high) / 2;
			return binarySum(data, low, mid) + binarySum(data, mid + 1, high);
		}
	}

}
