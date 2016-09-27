package com.shrvn.arrays.transverse;

/**
 * @author shravan
 *
 */
public class LargestContiguousSum {

	/**
	 * Kadane's algorithm
	 * the maximum subarray problem is the task
	 *  of finding the contiguous subarray
	 *  within a one-dimensional array of 
	 *  numbers which has the largest sum
	 *  Input: 
	    a = [-2, -3, 4, -1, -2, 1, 5, -3]
		Output:
             7 

	 */
	public static void main(String[] args) {
		int a[] ={-2, -3, 4, -1, -2, 1, 5, -3};
		int length=a.length;
		int[] result = result(a,length);
		printArray(result);

	}
	private static void printArray(int[] a) {
		for (int i = 0; i < a.length; i++) {
			if(a[i]!=0)
			System.out.print(a[i]+",");
		}
		System.out.println();
	}
	public static int[] result(int a[],int len) {
		int max_so_far=0,max_ending_here=0;
		int r[] = new int[len-1];
		boolean flag=false,first=true;
		for(int i=0,j=0;i<len;i++){
			max_so_far = max_so_far + a[i];
			if(!(max_so_far<0) || flag)
			r[j]=a[i];
			j++;flag=false;
			if(max_so_far<=0){
				if(max_so_far<0){
					r = new int[len-i-1];
					j=0;
				}
				first=true;
				max_so_far=0;
			}else if(max_so_far>max_ending_here){
				if(first){
					flag=true;
				}
				first=false;
				max_ending_here = max_so_far;
			}
		}
		System.out.println(max_ending_here);
		return r;
	}

}
