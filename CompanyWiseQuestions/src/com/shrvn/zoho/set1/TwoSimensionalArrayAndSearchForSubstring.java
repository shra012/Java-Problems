/**
 * 
 */
package com.shrvn.set1;

/**
 * @author Shravan
 *
 */
public class TwoSimensionalArrayAndSearchForSubstring {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s= "WELCOMETOZOHOCORPORATION";
		char[] a=s.toCharArray(); 
		char[][] m=new char[5][5];
		int i =0;
		for(int x=0;x<5;x++){
			for(int j=0;j<5;j++){
				if(i<a.length){
					m[x][j]=a[i];
					i++;
				}else{
					break;
				}
			}
		}
		for(int x=0;x<5;x++){
			for(int y=0;y<5;y++){
				System.out.print(m[x][y] +" ");
				if(y==4){
					System.out.println();
				}
			}
		}
		System.out.println(findIndex(m));

	}

	public static String findIndex(char[][] a){
		String s="";

		for(int x=0;x<5;x++){
			for(int y=0;y<5;y++){
				try{
					if(a[x][y] == 'T'&&a[x][y+1] == 'O'&&a[x][y+2] == 'O'){
						s=s+"<"+x+","+y+">"+"\n"+"<"+x+","+(y+2)+">";
					}


					if(a[x][y] == 'T'&&a[x+1][y] == 'O'&& a[x+2][y] == 'O'){
						s=s+"<"+x+","+y+">"+"\n"+"<"+(x+2)+","+y+">";
					}
				}catch(Exception e){
					continue;
				}
			}
		}
		return s;
	}















}
