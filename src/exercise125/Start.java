package exercise125;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.eclipsesource.json.Json;

class Solution {
    /**
     * 大小写字母的ASCII码不相等，先全转大写或小写(这里小写为例)，
     * 然后从中提取出只有数字和字母的字符串，最后折半比较，验证是否为回文串(也可以用String.reverse()与原串比较)
     */
    public boolean isPalindrome(String s) {
        if(s == null)
            return true;
        
        char[] source = s.trim().toLowerCase().toCharArray();
        StringBuffer buffer = new StringBuffer();
        
        for(char chara: source){
            if((chara > 96 && chara < 123) || (chara > 47 && chara < 58))
                buffer.append(chara);
        }
        
        if(buffer.length() == 0)
            return true;
        
        int middle = buffer.length() % 2;
        if(middle == 0){
            for(int index = 0; index < buffer.length() / 2 + 1; index++)
                if(buffer.charAt(index) != buffer.charAt(buffer.length() - 1 - index))
                    return false;
            return true;
        }else{
            for(int index = 0; index < buffer.length() / 2; index++)
                if(buffer.charAt(index) != buffer.charAt(buffer.length() - 1 - index))
                    return false;
            return true;
        }
        
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
            
            boolean ret = new Solution().isPalindrome(s);
            
            String out = booleanToString(ret);
            
            System.out.print(out);
        }
    }
}