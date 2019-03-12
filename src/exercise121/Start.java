package exercise121;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    /**
     * O(n^2)的暴力求解，遍历所有收益比较
     */
//    public int maxProfit(int[] prices) {
//        int profit = 0;
//        int currentProfit = 0;
//        if (prices.length < 2)
//            return profit;
//        
//        for (int index1 = 0; index1 < prices.length - 1; index1 ++){
//            for (int index2 = index1 + 1; index2 < prices.length; index2 ++){
//                currentProfit = prices[index2] - prices[index1];
//                profit = currentProfit > profit? currentProfit: profit;
//            }
//        }
//        return profit;
//    }
    
    /**
     * profit: 已知最大收益
     * currentProfit: 当前收益
     * min: 已知最低股价
     * 记录最小股价，用当前股价减最小股价，与已知最大收益比较后为最大收益赋值。
     * 若股价一直跌，则记录最小值到最后，收益为0。
     */
    public int maxProfit(int[] prices) {
        int profit = 0;
        int currentProfit = 0;
        int min = Integer.MAX_VALUE;
        
        for (int index = 0; index < prices.length; index++){
            if(prices[index] < min)
                min = prices[index];
            else{
                currentProfit = prices[index] - min;
                profit = currentProfit > profit? currentProfit: profit;
            }
        }
        return profit;
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
            int[] prices = stringToIntegerArray(line);
            
            int ret = new Solution().maxProfit(prices);
            
            String out = String.valueOf(ret);
            
            System.out.print(out);
        }
    }
}