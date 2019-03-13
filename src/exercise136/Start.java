package exercise136;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    /**
     * 按位异或(^)：转为二进制后，按位操作，相同得0，不同得1。
     * 性质：0异或一个数时，结果为那个数；一个数异或自己时，结果为0。
     * 除了只出现一次的数外，其余数均出现2次，利用异或的性质，依次异或取值即可得到结果。
     */
    public int singleNumber(int[] nums) {
        int single = 0;
        
        for(int index = 0; index < nums.length; index++){
             single = single ^ nums[index];
        }
        return single;
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
            
            int ret = new Solution().singleNumber(nums);
            
            String out = String.valueOf(ret);
            
            System.out.print(out);
        }
    }
}