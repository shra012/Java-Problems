/**
 * 
 */
package com.shrvn.arrays.transverse;

/**
 * @author Shravan
 *
 */
public class FindAllTripletsInASortedArrayThatFormsGeometricProgression {

	/**
	 *  Input: 
	    a = [1, 2, 6, 10, 18, 54]
		Output: 
		2 6 18
		6 18 54

		Input: 
		a = [2, 8, 10, 15, 16, 30, 32, 64]
		Output: 
		2 8 32
		8 16 32
		16 32 64

		Input: 
		a = [ 1, 2, 6, 18, 36, 54]
		Output: 
		2 6 18
		1 6 36
		6 18 54
	 */
	public static void main(String[] args) {
		int a[] = {2,10,15,50};
		int n = a.length;
		findGeometricTriplets(a, n);
	}

	static void findGeometricTriplets(int[] a,int l){
		for(int i =1;i<l-1;i++){
			int next =i+1;
			int previous = i-1;
			while(previous>=0 && next<=l-1){
				if(a[i]%a[previous]==0 && a[next]%a[i]==0 && a[i]/a[previous]==a[next]/a[i]){
					System.out.println(a[previous]+" "+a[i]+" "+a[next]);
				}
				/*if arr[j] is multiple of arr[i] and arr[k] is
	             multiple of arr[j], then arr[j] / arr[i] !=
	             arr[k] / arr[j]. We compare their values to
	             move to next k or previous i */
				if(a[i] % a[previous] == 0 && a[next] % a[i] == 0){
					if(a[i] / a[previous] < a[next] / a[i])
						previous--;
					else next++;
					/* else if arr[j] is multiple of arr[i], then
					 try next k. Else, try previous i.*/
				}else if (a[i] % a[previous] == 0){
					next++;
				}
				else previous--;
			}
		}
	} 
}
