/**
 * 
 */
package com.shrvn.set1;

/**
 * @author Shravan
 *
 */
public class SumOfWeights {

	/**
	 *  Given a set of numbers like <10, 36, 54,89,12> we want to find sum of weights based on the following conditions
	    1. 5 if a perfect square
	    2. 4 if multiple of 4 and divisible by 6
	    3. 3 if even number

		And sort the numbers based on the weight and print it as follows
		<10,its_weight>,<36,its weight><89,its weight>

		Should display the numbers based on increasing order.
	 */
	public static void main(String[] args) {
		int[] a = {10, 36, 54,89,12};
		int l = a.length;
		int[] weight = new int[a.length];
		for(int i = 0;i<l;i++){
			int sqrt = (int) findSquareRoot(a[i]);
			if(sqrt*sqrt == a[i]) {
				weight[i]=weight[i]+5;
			}
			if(a[i]%4==0 && a[i]%6==0){
				weight[i]=weight[i]+4;
			}
			if(a[i]%2==0){
				weight[i]=weight[i]+3;
			}
		}
		for(int i=0; i<a.length; i++)
			for(int j=i+1; j<a.length; j++)
				if(weight[i] < weight[j])
				{
					int temp = weight[i];
					weight[i] = weight[j];
					weight[j] = temp;
					temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
		for(int i=0; i<a.length; i++){
			System.out.print("<"+a[i]+","+weight[i]+">");
			if(i<a.length-1){
				System.out.print(",");
			}
		}

	}
	// to find sqrt
	public static double findSquareRoot(double number){

		boolean isPositiveNumber = true;
		double g1;

		//if the number given is a 0
		if(number==0)
		{
			System.out.println("Square root of "+number+" = "+0);
		}

		//If the number given is a -ve number
		else if(number<0)
		{
			number=-number;
			isPositiveNumber = false;
		}

		//Proceeding to find out square root of the number
		double squareRoot = number/2;
		do
		{
			g1=squareRoot;
			squareRoot = (g1 + (number/g1))/2;
		}
		while((g1-squareRoot)!=0);

		//Displays square root in the case of a positive number
		if(isPositiveNumber)
		{
			return squareRoot;
		}
		//Displays square root in the case of a -ve number
		else
		{
			return squareRoot;
		}

	
	}
	
	
	/*public static void main(String args[])
    {
        int[] numArray = {10,36,54,89,12};
        int numArraylen = numArray.length;
        
        for(int i=0; i<numArraylen; i++)
            for(int j=i+1; j<numArraylen; j++)
                if(numArray[i] > numArray[j])
                {
                    int temp = numArray[i];
                    numArray[i] = numArray[j];
                    numArray[j] = temp;
                }
        int[] wegArray = new int[numArraylen];
        
        for(int i=0; i<numArraylen; i++)
        {
            wegArray[i] = 0;
            int sq =(int) Math.sqrt(numArray[i]);
            if((sq*sq) == numArray[i])
                wegArray[i] = wegArray[i] + 5;
     
            if(numArray[i]%4==0 || numArray[i]%6==0)
                wegArray[i] = wegArray[i] + 4;
     
            if(numArray[i]%2 == 0)
                wegArray[i] = wegArray[i] + 3;
            
        }
        
        for(int i=0; i<numArraylen; i++)
            System.out.print("<"+numArray[i]+","+wegArray[i]+">,");
    }*/


}
