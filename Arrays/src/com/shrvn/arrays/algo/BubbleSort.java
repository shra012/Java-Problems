/**
 * 
 */
package com.shrvn.arrays.algo;

import java.util.Arrays;

/**
 * @author shravan
 *
 */
public class BubbleSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = {2,3,5,4,1};
		int length = array.length;
		array = bubbleSort(array,length);
		System.out.println(Arrays.toString(array));
	}
	public static int[] bubbleSort(int[] array,int length){
		for(int i=0;i<length-1;i++){
		for(int j=0;j<length-i-1;j++){
			int temp;
			if(array[j]>array[j+1]){
				temp=array[j];
				array[j]=array[j+1];
				array[j+1]=temp;
			}
		}
		}
		return array;
	}

}
