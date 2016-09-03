/**
 * 
 */
package com.shrvn.arrays.reverse;
import java.util.Scanner;

/**
 * @author Shravan
 *
 */
public class ReverseAnArrayInGroupsOfGivenSize {


	/* Input: 
		arr = [1, 2, 3, 4, 5, 6, 7, 8, 9]
		k = 3
		Output:  
		[3, 2, 1, 4, 5, 6, 9, 8, 7]
		
		Input: 
		arr = [1, 2, 3, 4, 5, 6, 7, 8]
		k = 2
		Output:  
		[2, 1, 3, 4, 6, 5, 7, 8]         
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		int [] a = {1,2,3,4,5,6,7,8,9,7,8,9,4,5,6,1,2,3};
		int length = a.length;
		int  ktemp=k-1;
		for(int i=0;i<length;i+=k){
			if(k==0){
				break;
			}
			if(i!=0){
				ktemp=i+k-1;
			}
			if(ktemp>length-1){
				ktemp=length-1;
			}
			reverse(a,i,ktemp);

		}
		for(int i =0;i<length;i++){
			System.out.print(a[i]+" ");
		}
		sc.close();
	}

	public static void reverse(int[] a,int start,int end) {
		if(start>=end){
			return;
		}	
		int temp = a[start];
		a[start] = a[end];
		a[end] =temp;
		reverse(a,start+1,end-1);
	}

}
