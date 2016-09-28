/**
 * 
 */
package com.shrvn.arrays.reverse;

import java.util.Arrays;

/**
 * @author shravan
 *
 */
public class ArrayTwoCandidates {

	/**
	 * 
	 */
	public static void main(String[] args) {
		int a[] = {1, 4, 45, 6, 10, 8};
        int sum = 16;
        int end = a.length-1;
        quickSort(a,0,end);
        int start=0;
        for (int i = 0; i < end; i++) {
			if(start<end){
				if(a[start]+a[end]==sum){
					System.out.println(a[start] +" "+a[end]);
				}else if(a[start]+a[end]<sum){
					start++;
				}else
					end--;
			}
		}
	}
	private static void quickSort(int a[],int start,int end) {
		if(start<end){
		int pIndex=partition(a,start,end);
		quickSort(a,start,pIndex-1);
		quickSort(a,pIndex+1,end);
		}
	}
	private static int partition(int a[],int start,int end) {
		int pivot = a[end];
		int pIndex=start;
		for(int i =start;i<end;i++){
			if(a[i]<=pivot){
				swap(a,i,pIndex);
				pIndex++;
			}
		}
		swap(a,pIndex,end);
		return pIndex;
	}
	private static void swap(int a[],int x,int y) {
		if(x!=y){
			a[x]=a[x]^a[y];
			a[y]=a[x]^a[y];
			a[x]=a[x]^a[y];
		}
	}

}
