/**
 * 
 */
package com.shrvn.recursion;

/**
 * @author shravan
 *
 */
public class PuzzleSolve {

	/**
	 * Driver unit to call the method puzzleSolve
	 */
	public static void main(String[] args) {
		char a[] ={'a','b','c'};
		int k=3;
		puzzleWrapper(k, a);
		puzzleSolve("","abc");
	}
	/**
	 * A puzzle solve to find all possible k length combinations
	 * of the characters in a char array
	 */
	public static void puzzleWrapper(int k,char[] a) {
		int size =a.length;
		puzzleSolve(k,"",size,a);

	}
	public static void puzzleSolve(int k,String s,int size,char[] a) {
		if(k==0){
			System.out.println(s); 
			return;
		}
		for(char c:a){
			String s1=s+c;
			puzzleSolve(k-1,s1,size,a);
		}
	}
	/**
	 * prints all permutations of a given string
	 */
	private static void puzzleSolve(String prefix, String str) {
		int n = str.length();
		if (n == 0) System.out.println(prefix);
		else {
			for (int i = 0; i < n; i++)
				puzzleSolve(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
		}
	}
}
