/**
 * 
 */
package com.shrvn.arrays.reverse;

import java.util.Arrays;

/**
 * @author shravan
 *
 */
public class MergeAnArrayOfSizeNIntoAnotherArrayOfSizeMN {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MergeAnArrayOfSizeNIntoAnotherArrayOfSizeMN merge = new MergeAnArrayOfSizeNIntoAnotherArrayOfSizeMN();
		  int mPlusN[] = {2, 8, -1, -1, -1, 13, -1, 15, 20};
	      int N[] = {5, 7, 9, 25};
	      //merge.move(mPlusN,N);
	      merge.moveToEnd(mPlusN);
	      System.out.println(Arrays.toString(N));
	      merge.merge(mPlusN, N);
	      System.out.println(Arrays.toString(mPlusN));
	}
	
	public void moveToEnd(int a[]) {
		int i,j;
		i=j=a.length-1;
		shravan :
		for (;i >=0;i--) {
			if(a[i]!=-1){
				a[j]=a[i];
				j--;	
			}if(i==-1){
				break shravan;
			}
		}
		System.out.println(Arrays.toString(a));
	}
	public static void merge(int a[],int b[]){
		int al=a.length;
		int bl=b.length;
		int i = bl;
		int j=0;
		int k=0;
		while (k<al){
			if(i<al && a[i]<=b[j] || j==al){
				a[k]=a[i];
				k++;
				i++;
			}else{
				a[k]=b[j];
				k++;
				j++;
			}
		}
		
	}
	
	//my method O(n2) time complexity
	public void move(int a[],int b[]) {
		Arrays.sort(a);
		for (int i = 0; i < b.length; i++) {
			if(a[i]==-1)
			a[i]=b[i];
		}
		Arrays.sort(a);
		System.out.println(Arrays.toString(a));
	}
}
