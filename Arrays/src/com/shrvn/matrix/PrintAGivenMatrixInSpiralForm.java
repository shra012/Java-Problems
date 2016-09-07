/**
 * 
 */
package com.shrvn.matrix;

/**
 * @author shravan
 *
 */
public class PrintAGivenMatrixInSpiralForm {

	/**
	 * Input:
        1    2   3   4
        5    6   7   8
        9   10  11  12
        13  14  15  16
		Output: 
		1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10 


		Input:
		        1   2   3   4  5   6
		        7   8   9  10  11  12
		        13  14  15 16  17  18
		Output: 
		1 2 3 4 5 6 12 18 17 16 15 14 13 7 8 9 10 11
	 */
	public static void main(String[] args) {
		int a[][] = { {1,  2,  3,  4,  5,  6},
				{7,  8,  9,  10, 11, 12},
				{13, 14, 15, 16, 17, 18}
		};
		int r = 3;
		int c = 6;
		method(a,r,c);
	}
	public static void method(int[][] a,int r,int c){
		int i = 0;
		int j=0;
		for(int l=0;l<a.length;l++){
			while(i<c-l){
				System.out.println(a[j][i]+" ");
				i++;
			}
			i=c-1-l;
			while(j<r-1-l){
				j++;
				System.out.println(a[j][i]+" ");
			}
			j=r-1-l;
			while(j==r-l){
				System.out.println(a[j][i]+" ");
				i--;
			}
			while(i!=0+l){
				System.out.println(a[j][i]+" ");
				j--;
			}


		}
	}

}
