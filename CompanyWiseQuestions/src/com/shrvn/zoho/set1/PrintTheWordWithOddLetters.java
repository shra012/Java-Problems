/**
 * 
 */
package com.shrvn.set1;

import java.util.Scanner;

/**
 * @author Shravan
 *
 */
public class PrintTheWordWithOddLetters {

	/**
	 * Print the word with odd letters as 
	 *  Input: 
		PROGRAM
		Output: 
		 P-----M
          R---A
		   O-R
		    G
		   O-R
		  R---A
		 P-----M
	 */
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	String input = sc.nextLine();
	input = input.trim();
    char a[] = input.toCharArray();
    for(int i=0,j=a.length-1;i<a.length&&j>=0;i++,j--){
    	if(i<j){
    		for(int s=0;s<i;s++){
    			System.out.print(" ");
    		}
    		System.out.print(a[i]);
    		
    		for(int x = i+1;x<j;x++){
    			System.out.print("-");
    		}
    		System.out.println(a[j]);
    	}
    	if(i==j){
    		for(int s=0;s<i;s++){
    			System.out.print(" ");
    		}
    		System.out.println(a[i]);
    	}
    	
    	if(i>j){
    		for(int s=0;s<j;s++){
    			System.out.print(" ");
    		}
    		System.out.print(a[j]);
    		
    		for(int x = j+1;x<i;x++){
    			System.out.print("-");
    		}
    		System.out.println(a[i]);
    	}
    }
	}

}
