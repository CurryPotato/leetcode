package exercise013;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.eclipsesource.json.Json;

class Solution {
    public int romanToInt(String s) {
    	int index = 0;
    	int total = 0;
    	for(;index < s.length(); index++){
    		switch (s.charAt(index)) {
			case 'M':
				total += 1000;
				break;
			case 'D':
				total += 500;
				break;
			case 'C':
				if(index < s.length()-1 && s.charAt(index + 1) == 'M'){
					total += 900;
					index++;
				}else if(index < s.length()-1 && s.charAt(index + 1) == 'D'){
					total += 400;
					index++;
				}else{
					total += 100;
				}
				break;
			case 'L':
				total += 50;
				break;
			case 'X':
				if(index < s.length()-1 && s.charAt(index + 1) == 'C'){
					total += 90;
					index++;
				}else if(index < s.length()-1 && s.charAt(index + 1) == 'L'){
					total += 40;
					index++;
				}else{
					total += 10;
				}
				break;
			case 'V':
				total += 5;
				break;
			case 'I':
				if(index < s.length()-1 && s.charAt(index + 1) == 'X'){
					total += 9;
					index++;
				}else if(index < s.length()-1 && s.charAt(index + 1) == 'V'){
					total += 4;
					index++;
				}else{
					total += 1;
				}
				break;
			default:
				break;
			}
    	}
        return total;
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
            
            int ret = new Solution().romanToInt(s);
            
            String out = String.valueOf(ret);
            
            System.out.print(out);
        }
    }
}
