/**
 * 
 */
package com.shrvn.matrix;

import java.util.Arrays;

/**
 * @author 965922
 *
 */
public class TimeMatrix {

	/**
	 * Input:
        1 2 4 5 6 6
		2 3 4 5 6 7
		2 3 4 5 6 7
		1 2 3 4 5 6
		Output: 
		124 
         3   max of sum of integers in all possible time capsule 19
        234 

		Input:
		        1   2   3   4  5   6
		        7   8   9  10  11  12
		        13  14  15 16  17  18
		Output:
		1   2   3
		    8      max of sum of integers in all possible time capsule 53
		13 14  15 
	 */
	public static void main(String[] args) {

		int a[][] = { {1, 2, 3, 4},
			          {5, 6, 7, 8},
			          {9, 10, 11, 12},
			          {13, 14, 15, 16}
			        };
		int x = a[0].length;
		int y = a.length;
		//find all possible time capsules
		getTimeCapsule(a,x,y);
		
	}
	
	public static void getTimeCapsule(int a[][],int x,int y){
		int j=0;
		int[] suma = new int[x+y];
		int sum=0;
		int index=0;
		for(int i =0;j<x;i++){
			try{
				System.out.println(a[j][i]+""+a[j][i+1]+""+a[j][i+2]+""+a[j+1][i+1]+""+a[j+2][i]+""+a[j+2][i+1]+""+a[j+2][i+2]);
			sum = a[j][i]+a[j][i+1]+a[j][i+2]+a[j+1][i+1]+a[j+2][i]+a[j+2][i+1]+a[j+2][i+2];
			suma[index]=sum;
			index++;
			}catch(ArrayIndexOutOfBoundsException e){
				j++;
				i=-1;
				continue;
			}
		}
		int i=0;
		for(j =0;i<y;j++){
			try{
				System.out.println(a[j][i]+""+a[j+1][i]+""+a[j+2][i]+""+a[j+1][i+1]+""+a[j][i+2]+""+a[j+1][i+2]+""+a[j+2][i+2]);
			sum = a[j][i]+a[j+1][i]+a[j+2][i]+a[j+1][i+1]+a[j][i+2]+a[j+1][i+2]+a[j+2][i+2];
			suma[index]=sum;
			index++;
			}catch(ArrayIndexOutOfBoundsException e){
				i++;
				j=-1;
				continue;
			}
		}
		System.out.println(Arrays.toString(suma));
		int temp=Integer.MIN_VALUE;
		for(int l = 0;l<suma.length-1;l++){
			if(temp<suma[l]){
				temp=suma[l];
			}
		}
		System.out.println("max of sum of integers in all possible time capsule "+temp);
	}
}
