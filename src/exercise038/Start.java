package exercise038;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public String countAndSay(int n) {
        String num = "1";
        StringBuffer buffer = new StringBuffer();
        for(int i = 1; i < n; i++){
        	int beginIndex = 0;
        	for(int index = 0; index < num.length(); index++){
        		if(index == num.length()-1 || num.charAt(index) != num.charAt(index+1)){
        			buffer.append(num.substring(beginIndex, index+1).length());
        			buffer.append(num.charAt(index));
        			beginIndex = index+1;
        		}
        	}
        	num = buffer.toString();
        	buffer.setLength(0);
        }
        return num;
    }
}

public class Start {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int n = Integer.parseInt(line);
            
            String ret = new Solution().countAndSay(n);
            
            String out = (ret);
            
            System.out.print(out);
        }
    }
}