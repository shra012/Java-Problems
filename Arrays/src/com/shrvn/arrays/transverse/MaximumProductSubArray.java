/**
 * 
 */
package com.shrvn.arrays.transverse;

/**
 * @author Shravan
 *
 */
public class MaximumProductSubArray {
	/**
	 * Input: arr[] = {6, -3, -10, 0, 2}
			  Output:   180  // The subarray is {6, -3, -10}

			  Input: arr[] = {-1, -3, -10, 0, 60}
			  Output:   60  // The subarray is {60}

			  Input: arr[] = {-2, -3, 0, -2, -40}
			  Output:   80  // The subarray is {-2, -40}
	 */
	public static void main(String[] args) {

		int[] a={-10};
		System.out.println(maxSubarrayProduct(a));
		
		int length=a.length;
		System.out.println(max_product(a,length));
		int rtlproduct;
		int ltrproduct;
		rtlproduct = rtlproduct(a,0);
		ltrproduct =ltrproduct(a,length-1);
		rtlproduct= Integer.max(rtlproduct, 0);
		ltrproduct =Integer.max(ltrproduct, 0);
		if(Math.abs(rtlproduct)>Math.abs(ltrproduct))
			System.out.println(Math.abs(rtlproduct));
		else
			System.out.println(Math.abs(ltrproduct));
	}

	public static int rtlproduct(int[] a,int i){
		return (a[i]==0 ||i==a.length-1)?1: a[i]*rtlproduct(a,i+1); 
	}

	public static int ltrproduct(int[] a,int i){
		return (a[i]==0||i==0)?1: a[i]*ltrproduct(a,i-1); 
	}


	// Utility functions to get minimum of two integers
	static int min (int x, int y) {
		return x < y? x : y; 
	}

	// Utility functions to get maximum of two integers
	static int max (int x, int y) {
		return x > y? x : y; 
	}

	/* Returns the product of max product subarray.
       Assumes that the given array always has a subarray
       with product more than 1 */
	static int maxSubarrayProduct(int arr[]) {
		int n = arr.length;
		// max positive product ending at the current position
		int max_ending_here = 1;

		// min negative product ending at the current position
		int min_ending_here = 1;

		// Initialize overall max product
		int max_so_far = 1;

		/* Traverse through the array. Following
           values are maintained after the ith iteration:
           max_ending_here is always 1 or some positive product
                           ending with arr[i]
           min_ending_here is always 1 or some negative product
                           ending with arr[i] */
		for (int i = 0; i < n; i++){
			/* If this element is positive, update max_ending_here.
                Update min_ending_here only if min_ending_here is
                negative */
			if (arr[i] > 0){
				max_ending_here = max_ending_here*arr[i];
				min_ending_here = min (min_ending_here * arr[i], 1);
			}

			/* If this element is 0, then the maximum product cannot
               end here, make both max_ending_here and min_ending
              _here 0
               Assumption: Output is alway greater than or equal to 1. */
			else if (arr[i] == 0){
				max_ending_here = 1;
				min_ending_here = 1;
			}

			/* If element is negative. This is tricky
               max_ending_here can either be 1 or positive.
               min_ending_here can either be 1 or negative.
               next min_ending_here will always be prev.
               max_ending_here * arr[i]
               next max_ending_here will be 1 if prev
               min_ending_here is 1, otherwise
               next max_ending_here will be 
                           prev min_ending_here * arr[i] */
			else{
				int temp = max_ending_here;
				max_ending_here = max (min_ending_here * arr[i], 1);
				min_ending_here = temp * arr[i];
			}

			// update max_so_far, if needed
			if (max_so_far <  max_ending_here)
				max_so_far  =  max_ending_here;
		}

		return max_so_far;
	}
	
	static int max_product(int arr[], int n)
	{
	    // Initialize maximum products in forward and
	    // backward directions
	    int max_fwd = Integer.MIN_VALUE, max_bkd = Integer.MIN_VALUE;
	 
	    // Initialize current product
	    int max_till_now = 1;
	 
	    // max_fwd for maximum contiguous product in
	    // forward direction
	    // max_bkd for maximum contiguous product in
	    // backward direction
	    // iterating within forward direction in array
	    for (int i=0; i<n; i++)
	    {
	        // if arr[i]==0, it is breaking condition
	        // for contiguos subarray
	        max_till_now = max_till_now*arr[i];
	        if (max_till_now == 0)
	        {
	             max_till_now = 1;
	            continue;
	        }
	        if (max_fwd < max_till_now) // update max_fwd
	            max_fwd = max_till_now;
	    }
	 
	     max_till_now = 1;
	 
	    // iterating within backward direction in array
	    for (int i=n-1; i>=0; i--)
	    {
	        max_till_now = max_till_now * arr[i];
	        if (max_till_now == 0)
	        {
	            max_till_now = 1;
	            continue;
	        }
	 
	        // update max_bkd
	        if (max_bkd < max_till_now)
	            max_bkd = max_till_now;
	    }
	 
	    // return max of max_fwd and max_bkd
	    int res =  max(max_fwd, max_bkd);
	 
	    // Product should not be nagative.
	    // (Product of an empty subarray is
	    // considered as 0)
	    return max(res, 0);
	}
}
