/**
 * 
 */
package com.shrvn.matrix;

import java.util.Arrays;

/**
 * @author shravan
 *
 */
public class BooleanMatrix {

	/**
	 *   Example 1
			The matrix
			1 0
			0 0
			should be changed to following
			1 1
			1 0

			Example 2
			The matrix
			0 0 0
			0 0 1
			should be changed to following
			0 0 1
			1 1 1

			Example 3
			The matrix
			1 0 0 1
			0 0 1 0
			0 0 0 0
			should be changed to following
			1 1 1 1
			1 1 1 1
			1 0 1 1
	 */
	public static void main(String[] args) {
		int a[][] = {{1,0,0,0},
				{0,0,1,0},
				{0,0,0,0}};
		int rl=a.length;
		int cl = a[0].length;
		printMatrix(a,rl,cl);
	}


	public static void printMatrix(int a[][],int rl,int cl) {
		int clone[][]=deepCopy(a);
		int i = 0,
			j = 0;	
		while(j<cl){
			if(i==rl-1){
				j++;
				i=0;
			}
			if(j==cl){
				continue;
			}
			if(a[i][j]==1){
				int r=0,c=0;
				for(int f =0;f<Integer.max(cl, rl);f++){
					if(r<rl){
						clone[r][j]=1;
						r++;
					}
					if(c<cl){
						clone[i][c]=1;
						c++;
					}
				}
				
			}
			i++;
		}

		printMatrix(clone);
	}

	public static void printMatrix(int mat[][])
	{
		int i, j;
		for (i = 0; i < mat.length; i++)
		{
			for (j = 0; j < mat[0].length; j++)
			{
				System.out.print( mat[i][j]);
			}
			System.out.println();

		}
	}
	
	public static int[][] deepCopy(int[][] original) {
	    if (original == null) {
	        return null;
	    }

	    final int[][] result = new int[original.length][];
	    for (int i = 0; i < original.length; i++) {
	        result[i] = Arrays.copyOf(original[i], original[i].length);
	    }
	    return result;
	}

}
