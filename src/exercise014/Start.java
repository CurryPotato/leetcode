package exercise014;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import com.eclipsesource.json.JsonArray;

class Solution {
    public String longestCommonPrefix(String[] strs) {
    	StringBuffer buffer = new StringBuffer();
    	
    	if(strs != null && strs.length > 0){
        	Arrays.sort(strs);
        	
        	char[] first = strs[0].toCharArray();
        	char[] last = strs[strs.length-1].toCharArray();
        	
        	for(int index = 0; index < first.length; index++){
        		if(first[index] == last[index]){
        			buffer.append(first[index]);
        		}else{
        			break;
        		}
        	}
    	}
    	
		return buffer.toString();
    }
}

public class Start {
    public static String[] stringToStringArray(String input) {
        JsonArray jsonArray = JsonArray.readFrom(input);
        String[] arr = new String[jsonArray.size()];
        for (int i = 0; i < arr.length; i++) {
          arr[i] = jsonArray.get(i).asString();
        }
        return arr;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String[] strs = stringToStringArray(line);
            
            String ret = new Solution().longestCommonPrefix(strs);
            
            String out = (ret);
            
            System.out.print(out);
        }
    }
}