package exercise002;

import java.io.IOException;

class ListNode {
    int val;
    ListNode next;
    
    ListNode (int x){
        val = x;
    }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode ret = result;
        int jinwei = 0;
        while(l1 != null || l2 != null || jinwei > 0){
            int num1 = l1 == null? 0: l1.val;
            int num2 = l2 == null? 0: l2.val;
            
            int num = num1 + num2 + jinwei;
            jinwei = num / 10;
            ret.next = new ListNode(num % 10);
            ret = ret.next;
            
            l1 = l1 == null? null: l1.next;
            l2 = l2 == null? null: l2.next;
        }
        
        return result.next;
    }
    
    
	public static void add(ListNode l1, ListNode l2, ListNode ret, int jinwei){
		if(l1 != null || l2 != null){
			if(l1 == null){
				l1 = new ListNode(0);
			}
			if(l2 == null){
				l2 = new ListNode(0);
			}
			int count = l1.val + l2.val + jinwei;
			jinwei = count / 10;
			ret.next = new ListNode(count % 10);
			System.out.println(ret.val);
			add(l1.next, l2.next, ret.next, jinwei);
		}
	}
}

public class Start {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
          return new int[0];
        }
    
        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }
    
    public static ListNode stringToListNode(String input) {
        // Generate array from the input
        int[] nodeValues = stringToIntegerArray(input);
    
        // Now convert that list into linked list
        ListNode dummyRoot = new ListNode(0);
        ListNode ptr = dummyRoot;
        for(int item : nodeValues) {
            ptr.next = new ListNode(item);
            ptr = ptr.next;
        }
        return dummyRoot.next;
    }
    
    public static String listNodeToString(ListNode node) {
        if (node == null) {
            return "[]";
        }
    
        String result = "";
        while (node != null) {
            result += Integer.toString(node.val) + ", ";
            node = node.next;
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }
    
    public static void main(String[] args) throws IOException {
//        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        String line;
//        while ((line = in.readLine()) != null) {
//            ListNode l1 = stringToListNode(line);
//            line = in.readLine();
//            ListNode l2 = stringToListNode(line);
//            
//            ListNode ret = new Solution().addTwoNumbers(l1, l2);
//            
//            String out = listNodeToString(ret);
//            
//            System.out.print(out);
    	
//    		ListNode l1 = new ListNode(2);
//    		l1.next = new ListNode(4);
//    		l1.next.next = new ListNode(3);
//    		
//    		ListNode l2 = new ListNode(5);
//    		l2.next = new ListNode(6);
//    		l2.next.next = new ListNode(4);
    	
			ListNode l1 = new ListNode(5);
			
			ListNode l2 = new ListNode(5);
    		System.out.println("录入完成");
    		ListNode ret = new Solution().addTwoNumbers(l1, l2);
    		
    		String out = listNodeToString(ret);
    		System.out.print(out);
//        }
    }
}

