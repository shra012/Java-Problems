/**
 * 
 */
package com.shrvn.recursion;

/**
 * @author shravan
 *
 */
public class Unique {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] data={3,3,4,1,3,5,6,7};
		System.out.println(unique(data,1,2));
	}
	
	public static boolean unique(int[] data, int low, int high) {
		if(low >=high) return true;
		else if(!unique(data,low,high-1)) return false;
		else if (!unique(data, low+1, high)) return false;
		else return (data[low] != data[high]);
	}

}
