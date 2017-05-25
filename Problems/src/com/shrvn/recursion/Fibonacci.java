package com.shrvn.recursion;

public class Fibonacci {
	public static void main(String[] args) {
		int n=10;
		for(int i=0,j=0;i<=n;i++){
		System.out.println(fibonacci(j++));
		}
		
	}
	public static int fibonacci(int number) {
		if(number == 0){
			return 0;
		}
		if (number == 1 || number == 2) {
			
			return 1;
		}
		
		return fibonacci(number - 1) + fibonacci(number - 2);
	 
	}
	
}
