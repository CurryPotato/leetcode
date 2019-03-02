package exercise009;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0){
        	return false;
        }
        
        String x1 = String.valueOf(x);
        int length = x1.length() % 2 == 0? x1.length()/2: x1.length()/2 + 1;
        for(int index = 0; index < length; index++){
        	if(x1.charAt(index) != x1.charAt(x1.length() - 1 - index)){
        		return false;
        	}
        }
        
        return true;
    }
}

public class Start {
    public static String booleanToString(boolean input) {
        return input ? "True" : "False";
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int x = Integer.parseInt(line);
            
            boolean ret = new Solution().isPalindrome(x);
            
            String out = booleanToString(ret);
            
            System.out.print(out);
        }
    }
}