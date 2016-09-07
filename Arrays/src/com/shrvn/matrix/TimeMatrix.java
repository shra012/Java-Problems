/**
 * 
 */
package com.shrvn.matrix;

/**
 * @author 965922
 *
 */
public class TimeMatrix {

	/**
	 * Input:
        1 2 4 5 6 6
		2 3 4 5 6 7
		2 3 4 5 6 7
		1 2 3 4 5 6
		Output: 
		124 
         3   max of sum of integers in all possible time capsule 19
        234 

		Input:
		        1   2   3   4  5   6
		        7   8   9  10  11  12
		        13  14  15 16  17  18
		Output:
		1   2   3
		    8      max of sum of integers in all possible time capsule 53
		13 14  15 
	 */
	public static void main(String[] args) {

		int a[][] = { {1, 2, 3, 4},
			          {5, 6, 7, 8},
			          {9, 10, 11, 12},
			          {13, 14, 15, 16}
			        };
		
		//find all possible time capsules
		getTimeCapsule();
	}
	
	public static void getTimeCapsule(){
		
	}

}
