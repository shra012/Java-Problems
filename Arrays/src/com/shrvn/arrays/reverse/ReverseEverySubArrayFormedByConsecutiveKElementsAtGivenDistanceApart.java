/**
 * 
 */
package com.shrvn.arrays.reverse;

/**
 * @author Shravan
 *
 */
public class ReverseEverySubArrayFormedByConsecutiveKElementsAtGivenDistanceApart {

	/**
	 * arr = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
			 k = 3
			 m = 2
			 Output:  
			 [3, 2, 1, 4, 5, 8, 7, 6, 9, 10]

			 Input: 
			 arr = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
			 k = 3
			 m = 1
			 Output:  
			 [3, 2, 1, 4, 7, 6, 5, 8, 10, 9]

			 Input: 
			 arr = [1, 2, 3, 4, 5, 6, 7, 8]
			 k = 2
			 m = 0
			 Output:  
			 [2, 1, 4, 3, 6, 5, 8, 7]
	 */
	public static void main(String[] args) {
		int a[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int k=3;
		int m=1;
		int length=a.length;
		int ktemp=k-1;
		for(int i=0;i<length;i+=k+m){
			if(k==0){
				break;
			}
			if(i!=0){
				ktemp=(k-1)+i;
			}

			if(ktemp>length-1){
				ktemp=length-1;
			}
			reverse(a,i,ktemp);
		}
		for(int i=0;i<length;i++){
         System.out.print(a[i]+" ");
		}

	}
	
	static void reverse(int[] a,int start,int end){
		if(start>=end){
			return;
		}
		int temp=a[start];
		a[start]=a[end];
		a[end]=temp;
		reverse(a,start+1,end-1);
	}
}