package exercise066;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public int[] plusOne(int[] digits) {
        
    	boolean highestFlag = true;
    	digits[digits.length-1] += 1;
    	for(int index = digits.length-1; index >= 0; index--){
    		if(digits[0] >= 10){
    			highestFlag = false;
    			break;
    		}else if(digits[index] >= 10){
    			digits[index-1] += digits[index]/10;
    			digits[index] %= 10;
    		}
    	}
    	
    	if(!highestFlag){
    		int[] highest = new int[digits.length + 1];
    		highest[0] = digits[0] / 10;
    		digits[0] %= 10;
    		System.arraycopy(digits, 0, highest, 1, digits.length);
    		return highest;
    	}
    	
    	return digits;
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
    
    public static String integerArrayToString(int[] nums, int length) {
        if (length == 0) {
            return "[]";
        }
    
        String result = "";
        for(int index = 0; index < length; index++) {
            int number = nums[index];
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }
    
    public static String integerArrayToString(int[] nums) {
        return integerArrayToString(nums, nums.length);
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] digits = stringToIntegerArray(line);
            
            int[] ret = new Solution().plusOne(digits);
            
            String out = integerArrayToString(ret);
            
            System.out.print(out);
        }
    }
}