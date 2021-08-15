/**
 * 
 */
package com.shrvn.matrix;

/**
 * @author Shravan
 *
 */
public class SearchInARowWiseAndColumnWiseSortedMatrix {

	/**
	 * Input Marix
	 * int mat[][] = { {10, 20, 30, 40},
                         {15, 25, 35, 45},
                         {27, 29, 37, 48},
                         {32, 33, 39, 50},
                       };
       OutPut
       index : <2,1>
	 */
	public static void main(String[] args) {
		int mat[][] = { {10, 20, 30, 40},
		                {15, 25, 35, 45},
		                {27, 29, 37, 48},
		                {32, 33, 39, 50},
		              };
		System.out.println(findIndex(mat,33));
	}
	
	static String findIndex(int[][] a,int x){
		int i=0,j=3;
		while(i<4&&j>=0){
			if(a[i][j]==x){
				return "<"+i+","+j+">";
			}
			if(a[i][j]<x){
				i++;
				continue;
			}
			if(a[i][j]>x){
				j--;
				continue;
			}
		}
		return "Not Found";
	}

}
