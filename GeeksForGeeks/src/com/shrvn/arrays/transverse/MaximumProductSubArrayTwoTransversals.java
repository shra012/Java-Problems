/**
 * 
 */
package com.shrvn.arrays.transverse;

/**
 * @author shravan
 *
 */
public class MaximumProductSubArrayTwoTransversals {

	/**
	 *  Input: arr[] = {6, -3, -10, 0, 2}
			  Output:   180  // The subarray is {6, -3, -10}

			  Input: arr[] = {-1, -3, -10, 0, 60}
			  Output:   60  // The subarray is {60}

			  Input: arr[] = {-2, -3, 0, -2, -40}
			  Output:   80  // The subarray is {-2, -40}
	 */
	public static void main(String[] args) {
		int a[] = {6, -3, 10,-10, 0, 2};
		int result = maxContinousProduct(a);
		System.out.println(result);
	}
	public static int maxContinousProduct(int a[]) {
		int max_so_far=1;
		int min_so_far=1;
		int max_ending_here=1;
		for(int i =0;i<a.length;i++){
			if(a[i]>0){
				max_so_far = max_so_far * a[i];
				min_so_far = min(min_so_far * a[i] ,1);
			}
			else if(a[i]==0){
				 max_so_far=1;
				 min_so_far=1;
			}
			else{
				int temp = max_so_far;
				max_so_far= max(min_so_far*a[i],1);
				min_so_far=temp*a[i];
			}
			
			if(max_so_far>max_ending_here){
				max_ending_here=max_so_far;
			}
			
		}
		return max_ending_here;
	}
	
	public static int max(int x,int y) {return (x>y)?x:y;}
	public static int min(int x,int y) {return (x<y)?x:y;}

}
