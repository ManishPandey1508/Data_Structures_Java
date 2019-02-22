package Stacks;

import java.util.Stack;

/*Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.


The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!

Example:

Input: [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6*/

public class TrappingRainWater {

	public static void main(String[] args) {
		int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println("Water Quantity"+ trap(height));

	}

	public static int trap(int[] height) {

		 
        if(height==null || height.length==0)
            return 0;
        
        int length = height.length;
        
        int[] leftToRight = new int[length];
        
        int[] rightToLeft = new int[length];
       
        int max = height[0];
        leftToRight[0]= height[0];
        
        for(int i=1;i< length;i++){
           max = Math.max(max,height[i]);
             leftToRight[i] = max;
        }
        max = height[length-1];
        rightToLeft[length-1] = max;
        
           for(int i=length-2;i>=0;i--){
            max = Math.max(max,height[i]);
               rightToLeft[i] = max;
        }
        
        int water =0;
        
        for(int i=0;i<length;i++){
         
            water+= Math.min(leftToRight[i],rightToLeft[i])- height[i];
            
        }
        
        return water;
	}

}
