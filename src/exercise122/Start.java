package exercise122;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    /**
     * profit: 已知最大收益
     * buy: 购入时价格
     * trend: 明日价格对比今日价格走势(true: 走高, false: 走低)
     * hold: 是否持有股票
     * 
     * 每日只可进行一次买入或卖出操作，只能同时持有一只股票。
     * 收益基础为低价买入，高价卖出。
     * 共存在四种情况：
     * 1.持有股票，明日价格走高：等待。
     * 2.持有股票，明日价格走低：卖出。
     * 3.未持有股票，明日价格走高：买入。
     * 4.未持有股票，明日价格走低：等待。
     * 
     * 最后一日仍持有股票说明前一日只存在情况1和3，卖出即可。
     */
    
    public int maxProfit(int[] prices) {
        int profit = 0;
        int buy = 0;
        boolean trend = false;
        boolean hold = false;
        for(int index = 0; index < prices.length; index++){
            if (index + 1 < prices.length){
                trend = prices[index + 1] > prices[index];
                if (hold && !trend){
                    profit += prices[index] - buy;
                    hold = false;
                }else if (!hold && trend){
                    buy = prices[index];
                    hold = true;
                }else{
                    continue;
                }
            }else {
                if(hold){
                    profit += prices[index] - buy;
                    hold = false;
                }
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