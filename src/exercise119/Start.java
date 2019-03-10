package exercise119;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Solution {

    private List<Integer> getPascalTriangleRow(List<Integer> parent, int rowIndex, int row){
        List<Integer> result = new ArrayList<>();
        
        result.add(1);
        for(int index = 1; index < row - 1; index ++){
            int temp = parent.get(index - 1) + parent.get(index);
            result.add(temp);
        }
        result.add(1);
        if(row == rowIndex)
            return result;
        return getPascalTriangleRow(result, rowIndex, row + 1);
    }
    
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        if(rowIndex == 0){
            result.add(1);
            return result;
        }
        result.add(1);
        rowIndex++;
        return getPascalTriangleRow(result, rowIndex, 1);
    }
    
}

public class Start {
    public static String integerArrayListToString(List<Integer> nums, int length) {
        if (length == 0) {
            return "[]";
        }
    
        String result = "";
        for(int index = 0; index < length; index++) {
            Integer number = nums.get(index);
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }
    
    public static String integerArrayListToString(List<Integer> nums) {
        return integerArrayListToString(nums, nums.size());
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int rowIndex = Integer.parseInt(line);
            
            List<Integer> ret = new Solution().getRow(rowIndex);
            
            String out = integerArrayListToString(ret);
            
            System.out.print(out);
        }
    }
}