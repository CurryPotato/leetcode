package exercise067;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public String addBinary(String a, String b) {
/**
 * 对齐字符串按位运算
 */
//    	int length = a.length()-b.length();
//        if(length < 0){
//        	String temp = a;
//        	a=b;
//        	b=temp;
//        }
//        for(int i = 0; i < Math.abs(length); i++)
//        	b = "0" + b;
//        
//        StringBuffer result = new StringBuffer();
//        int jinwei = 0;
//        for(int index = a.length()-1; index >= 0; index--){
//        	int abit = Integer.valueOf(a.substring(index, index+1));
//        	int bbit = Integer.valueOf(b.substring(index, index+1));
//        	String bit = String.valueOf( (abit + bbit + jinwei) % 2);
//        	if((abit + bbit + jinwei) / 2 == 1){
//        		jinwei = 1;
//        	}else{
//        		jinwei = 0;
//        	}
//        	result.append(bit);
//        }
//        
//        if(jinwei == 1)
//        	result.append(1);
//        
//        return result.reverse().toString();
    	
/**
 * 不对齐字符串，直接补位
 */
    	
    	StringBuffer result = new StringBuffer();
    	int jinwei = 0;
    	for(int i = a.length()-1, j = b.length()-1; i >= 0 || j >= 0; i--,j--){
    		int abit = i >= 0? a.charAt(i)-'0': 0;
    		int bbit = j >= 0? b.charAt(j)-'0': 0;
    		result.append((abit + bbit + jinwei) % 2);
    		if((abit + bbit + jinwei) / 2 > 0)
    			jinwei = 1;
    		else
    			jinwei = 0;
    	}
    	if(jinwei > 0)
    		result = result.append(1);
    	return result.reverse().toString();
    }
}

public class Start {
    public static String stringToString(String input) {
        if (input == null) {
            return "null";
        }
        return input;
//        return Json.value(input).toString();
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String a = stringToString(line);
            line = in.readLine();
            String b = stringToString(line);
            
            String ret = new Solution().addBinary(a, b);
            
            String out = (ret);
            
            System.out.print(out);
        }
    }
}