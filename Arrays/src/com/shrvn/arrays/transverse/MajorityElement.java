/**
 * 
 */
package com.shrvn.arrays.transverse;

/**
 * @author 965922
 *
 */
public class MajorityElement {

	/**
	 * I/P : 3 3 4 2 4 4 2 4 4
       O/P : 4 

       I/P : 3 3 4 2 4 4 2 4
       O/P : NONE
	 */
	public static void main(String[] args) {
		int a[] = {122,122,5,122,6};
		int l=a.length;
		getMajorityElement(a,l);
	}

	public static void getMajorityElement(int a[],int l) {
		int majorityElement =  getElement(a,l);
		int count=0;
		for (int i = 0; i < a.length; i++) {
			if(majorityElement==a[i])
				count++;
		}
			if(count>l/2)
				System.out.println(majorityElement);
			else
				System.out.println("NONE");
	}

	public static int getElement(int a[],int l) {
		int maj_index=0,count=1;
		for (int i = 1; i < a.length; i++) {
			if(a[i]==a[maj_index]){
				count++;
			}else{
				count--;
			}
			if(count==0){
				maj_index++;
				count=1;
			}
		}
		return a[maj_index];
	}

}
