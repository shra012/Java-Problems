package com.shrvn.leetcode.medium.array;

public class ContainerWithMostWater {
    public int maxArea(int[] a) {
        int s = 0;
        int e = a.length -1;
        int max = 0;
        while(s < e){
            int w = Math.min(a[s] , a[e]);
            int l = e - s;
            int area = l * w;

            if(max < area){
                max = area;
            }

            if(a[s] < a[s+1]){
                s++;
            }else{
                e--;
            }

        }
        return max;
    }

    public static void main(String[] args) {
        int[] input = {1,3,2,5,25,24,5};
        ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();
        System.out.println(containerWithMostWater.maxArea(input));
    }
}
