package com.shrvn.algo;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author Shravan
 *
 */
public class AngryProfessor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int t,n,k,i,x,c;
		Scanner sc = new Scanner(System.in);
		t=sc.nextInt();
		while (t-->0){
			c=0;
			n = sc.nextInt();
			k=sc.nextInt();
			for (i=0; i<n; i++){
				x = sc.nextInt();
				if (x<=0)
					c++;
			}
			if (c>=k){
				System.out.println("NO");
			}
			else{
				System.out.println("YES");
			}
		}
		sc.close();

	}

	public static int find(){
		int t,n,k,i,x,c;
		Scanner sc = new Scanner(System.in);
		t=sc.nextInt();
		while (t-->0){
			c=0;
			n = sc.nextInt();
			k=sc.nextInt();
			for (i=0; i<n; i++){
				x = sc.nextInt();
				if (x<=0)
					c++;
			}
			if (c>=k){
				System.out.println("NO");
			}
			else{
				System.out.println("YES");
			}
		}
		sc.close();
		return 0;
	}
}
