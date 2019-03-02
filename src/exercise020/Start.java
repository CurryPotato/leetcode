package exercise020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.eclipsesource.json.Json;

class Solution {
    public boolean isValid(String s) {

    	StringBuffer buffer = new StringBuffer();
    	boolean flag = true;
    	
    	for(int index = 0; index < s.length(); index++){
    		switch (s.charAt(index)) {
			case '(':
				buffer.append(')');
				break;
			case '[':
				buffer.append(']');
				break;
			case '{':
				buffer.append('}');
				break;
			case ')':
				if(buffer.length() > 0 && buffer.charAt(buffer.length()-1) == ')')
					buffer.deleteCharAt(buffer.length()-1);
				else{
					index = s.length();
					flag = false;
				}
				break;
			case ']':
				if(buffer.length() > 0 && buffer.charAt(buffer.length()-1) == ']')
					buffer.deleteCharAt(buffer.length()-1);
				else{
					index = s.length();
					flag = false;
				}
				break;
			case '}':
				if(buffer.length() > 0 && buffer.charAt(buffer.length()-1) == '}')
					buffer.deleteCharAt(buffer.length()-1);
				else{
					index = s.length();
					flag = false;
				}
				break;
			default:
				break;
			}
    	}
    	
    	if(flag && buffer.length() == 0)
    		return true;
    	else
    		return false;
    }
}

public class Start {
    public static String stringToString(String input) {
        if (input == null) {
            return "null";
        }
        return Json.value(input).toString();
    }
    
    public static String booleanToString(boolean input) {
        return input ? "True" : "False";
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String s = stringToString(line);
            
            boolean ret = new Solution().isValid(s);
            
            String out = booleanToString(ret);
            
            System.out.print(out);
        }
    }
}