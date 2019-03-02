package exercise007;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public int reverse(int x) {
        char[] x1 = String.valueOf(x).toCharArray();
        StringBuffer x2 = new StringBuffer();
        
        int min = 0;
        if(x1[0] == '-'){
            min = 1;
        }
        
        for(int index = x1.length -1; index >= min; index--){
            x2.append(x1[index]);
        }
        int result = 0;
        try{
            result = Integer.parseInt(x2.toString());
            
            if(x < 0){
                result = result * (-1);
            }
        }catch(NumberFormatException e){
            return 0;
        }
        
        
        return result;
    }
}

public class Start {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int x = Integer.parseInt(line);
            
            int ret = new Solution().reverse(x);
            
            String out = String.valueOf(ret);
            
            System.out.print(out);
        }
    }
}
