package exercise028;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public int strStr(String haystack, String needle) {
//    	return haystack.indexOf(needle);
    	if(needle.length() == 0)
    		return 0;
    	if(haystack.length() == 0)
    		return -1;
    	for(int index = 0; index < haystack.length()-needle.length()+1; index++){
    		if(haystack.substring(index, index + needle.length()).equals(needle)){
    			return index;
    		}
    	}
    	return -1;
    }
}
//
//hello
//01234    length=5
//ll

public class Start {
    public static String stringToString(String input) {
        if (input == null) {
            return "null";
        }
//        return Json.value(input).toString();
        return input;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String haystack = stringToString(line);
            line = in.readLine();
            String needle = stringToString(line);
            
            int ret = new Solution().strStr(haystack, needle);
            
            String out = String.valueOf(ret);
            
            System.out.print(out);
        }
    }
}