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
		int a[][] = { {1,  2,  3,  4},
				    {5,6,7,  8},
				    {9,10,11,  12},
				    {13, 14, 15, 16}
		};
		int r = 4;
		int c = 4;
		spiralPrint(r,c,a);
		method(r,c,a);
	}
	public static void method(int r,int c,int[][] a){
		int i = 0;
		int j=0;
		for(int l=0;l<a.length;l++){
			if(l!=0){
				r=r-1;
				c=c-1;		
			}
			i=l;
			while(i<=c-1){
				System.out.print(a[j][i]+" ");
				i++;
			}
			i=c-1-l;
			while(j<r-1-l){
				j++;
				System.out.print(a[j][i]+" ");
			}
			j=r-1-l;
			while(i>=l){
				i--;
				if(i<0){
					break;
				}
				System.out.print(a[j][i]+" ");
			}
			i=0;
			j=r-1;
			while(j>l+1){
				--j;
				System.out.print(a[j][i]+" ");
				
			}
		}
	}
	
	static void spiralPrint(int m, int n, int a[][])
	{
	    int i, k = 0, l = 0;
	 
	    /*  k - starting row index
	        m - ending row index
	        l - starting column index
	        n - ending column index
	        i - iterator
	    */
	 
	    while (k < m && l < n)
	    {
	        /* Print the first row from the remaining rows */
	        for (i = l; i < n; ++i)
	        {
	            System.out.print(a[k][i]+" ");
	        }
	        k++;
	 
	        /* Print the last column from the remaining columns */
	        for (i = k; i < m; ++i)
	        {
	            System.out.print(a[i][n-1]+" ");
	        }
	        n--;
	 
	        /* Print the last row from the remaining rows */
	        if ( k < m)
	        {
	            for (i = n-1; i >= l; --i)
	            {
	                System.out.print(a[m-1][i]+" ");
	            }
	            m--;
	        }
	 
	        /* Print the first column from the remaining columns */
	        if (l < n)
	        {
	            for (i = m-1; i >= k; --i)
	            {
	                System.out.print(a[i][l]+" ");
	            }
	            l++;    
	        }        
	    }
	    System.out.println();
	}

}
