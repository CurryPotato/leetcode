package exercise053;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE, thisSum = 0;
        
        if(nums.length == 1)
            return nums[0];
        
        for(int i = 0; i < nums.length; i++){
            
            if(thisSum > 0)
                thisSum += nums[i];
            else
                thisSum = nums[i];
            
            if(thisSum > maxSum)
                maxSum = thisSum;
            
        }
        return maxSum;
    }
}

public class Start {
    
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
          return new int[0];
        }
    
        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] nums = stringToIntegerArray(line);
            
            int ret = new Solution().maxSubArray(nums);
            
            String out = String.valueOf(ret);
            
            System.out.print(out);
        }
    }
}