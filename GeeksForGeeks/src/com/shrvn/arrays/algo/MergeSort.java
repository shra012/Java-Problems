/**
 * 
 */
package com.shrvn.arrays.algo;

/**
 * @author shravan
 *
 */
public class MergeSort {

	/**
	 * 
	 */
	public static void main(String[] args) {
		int a[] = {10, 11, 9, 8, 6, 7};
		int length = a.length-1;
		int start = 0;
		sort(a,start,length);
		printArray(a);
	}
	public static void  sort(int a[],int start,int length){
		if(start<length){
			int mid = (start+length)/2;
			sort(a,start,mid);
			sort(a,mid+1,length);
			merge(a,start,mid,length);
		}
	}
	public	static void merge(int a[],int start,int mid,int length){
		int asize=mid-start+1;
		int bsize=length-mid;
		int l[]= new int[asize];
		int r[]= new int[bsize];
		for(int i = 0;i<asize;i++){
			l[i]=a[start+i];
		}
		for(int i = 0;i<bsize;i++){
			 r[i] = a[mid+1+i];
		}
		 int i = 0, j = 0;
		 
	        // Initial index of merged subarry array
	        int k = start;
	        while (i < asize && j < bsize)
	        {
	            if (l[i] <= r[j])
	            {
	                a[k] = l[i];
	                i++;
	            }
	            else
	            {
	                a[k] = r[j];
	                j++;
	            }
	            k++;
	        }
	 
	        /* Copy remaining elements of L[] if any */
	        while (i < asize)
	        {
	            a[k] = l[i];
	            i++;
	            k++;
	        }
	 
	        /* Copy remaining elements of R[] if any */
	        while (j < bsize)
	        {
	            a[k] = r[j];
	            j++;
	            k++;
	        }

	}
	
	static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }


}
