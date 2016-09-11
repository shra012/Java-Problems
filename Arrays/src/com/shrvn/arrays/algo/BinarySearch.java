/**
 * 
 */
package com.shrvn.arrays.algo;

import java.util.Scanner;

/**
 * @author shravan
 *
 */
public class BinarySearch {

	/**
	 * @param args
	 */
	//Find Largest and Smallest Number in an Array
	//Finding Largest and Smallest in O(n) time
	/*   Input
	 *   5/1,2,3,4,5/Some number in array say 5
	 *   Output
	 *   BinarySearch  :5 
	 */   
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int i = 0;
		int[] array = new int[n];
		String s = sc.next();
		int num = sc.nextInt();
		String[] sa= s.split(",");
		for(String st:sa){
			array[i++]=Integer.parseInt(st);
		}
		System.out.println(linearSearch(array,num));
		System.out.println(binarySearchMine(array,num));
		binarySearch(array,0,array.length,array[4]);
		binarySearch(array,7);
		sc.close();
	}
	
    //The time complexity of below algorithm is O(n). 
	public static int linearSearch(int[] array,int n){

		for(int i=0;i<array.length;i++){
			if(n==array[i]){
				return i;
			}
		}
		return -1;
	}
	
	public static int binarySearchMine(int[] array,int n){
		int middleValue = array.length/2;
		if(n>middleValue){
			for(int i=middleValue;i<array.length;i++){
				if(n==array[i]){
					return i;
				}
			}
		}else{
			for(int i=0;i<middleValue;i++){
				if(n==array[i]){
					return i;
				}
			}
		}
		return -1;
	}
	
	public static int binarySearch(int arr[], int start, int length, int x){
        if (length>=start){
            int mid = start + (length - start)/2;
 
            // If the element is present at the middle itself
            if (arr[mid] == x)
               return mid;
 
            // If element is smaller than mid, then it can only
            // be present in left subarray
            if (arr[mid] > x)
               return binarySearch(arr, start, mid-1, x);
 
            // Else the element can only be present in right
            // subarray
            return binarySearch(arr, mid+1, length, x);
        }
 
        // We reach here when element is not present in array
        return -1;
    }
	
	public static int binarySearch(int arr[], int x)
    {
        int start = 0, size = arr.length - 1;
        while (start <= size)
        {
            int m = start + (size-start)/2;
 
            // Check if x is present at mid
            if (arr[m] == x)
                return m;
 
            // If x greater, ignore left half
            if (arr[m] < x)
                start = m + 1;
 
            // If x is smaller, ignore right half
            else
                size = m - 1;
        }
 
        // if we reach here, then element was not present
        return -1;
    }

}
