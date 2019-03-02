package exercise003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

import com.eclipsesource.json.Json;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<Character>();
        int maxLength = 0;
        for(int index = 0, i = 0; index < s.length(); index++){
            if(!set.add(s.charAt(index))){
                if(set.size() > maxLength)
                    maxLength = set.size();
                set.clear();
                index = i++;
            }
        }
        if(set.size() > maxLength)
            maxLength = set.size();
        return maxLength;
        
    }
}

public class Start {
    public static String stringToString(String input) {
        if (input == null) {
            return "null";
        }
        return Json.value(input).toString();
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String s = stringToString(line);
            
            int ret = new Solution().lengthOfLongestSubstring(s);
            
            String out = String.valueOf(ret);
            
            System.out.print(out);
        }
    }
}
