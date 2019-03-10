package exercise118;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if(numRows == 0)
            return result;
        
        for(int row = 1; row <= numRows; row ++){

            List<Integer> rowList = new ArrayList<>(row);
            
            if(row == 1){
                rowList.add(1);
                result.add(rowList);
                continue;
            }
            
            
            rowList.add(1);
            
            for(int index = 0; index < row - 2; index ++){
                int temp = result.get(row - 2).get(index) + result.get(row - 2).get(index + 1);
                rowList.add(temp);
            }
            
            rowList.add(1);
            result.add(rowList);
            
        }
        return result;
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
    
    public static String int2dListToString(List<List<Integer>> nums) {
        StringBuilder sb = new StringBuilder("[");
        for (List<Integer> list: nums) {
            sb.append(integerArrayListToString(list));
            sb.append(",");
        }
    
        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int numRows = Integer.parseInt(line);
            
            List<List<Integer>> ret = new Solution().generate(numRows);
            
            String out = int2dListToString(ret);
            
            System.out.print(out);
        }
    }
}