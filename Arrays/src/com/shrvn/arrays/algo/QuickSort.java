/**
 * 
 */
package com.shrvn.arrays.algo;

/**
 * @author 965922
 *
 */
public class QuickSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a[] = {7,2,1,6,8,5,3,4};
		int end = a.length-1;
		int start = 0;
		//swap(a,0,7);
		//printArray(a);
		
		//quickSort(a,start,end);
	}
	
    public static void quickSort(int a[],int start,int end) {
    	if(start<end){
    	
    		
    	}
	}
    
    public static void partition(int a[],int start,int end) {
    	int pivot = a[end];
		int pIndex=a[start];
		//Swap method
		for(int i=start;i<end;i++){
			if(a[i]<=pivot){
				swap(a,a[i],a[pIndex]);
				pIndex = pIndex+1;
			}
		}
	}
    
    public static void printArray(int a[]) {
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]);
			if(i<a.length-1)
				System.out.print(","+" ");
		}

	}
    
    public static void swap(int a[],int x, int y){
    	//if x = 10 y= 5
    	  a[x] = a[x] ^a[y];  // x now becomes 15 (1111)
    	  a[y] = a[x] ^ a[y];  // y becomes 10 (1010)
    	  a[x] = a[x] ^ a[y];  // x becomes 5 (0101)
    }

}
