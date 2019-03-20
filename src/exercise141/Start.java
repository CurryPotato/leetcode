package exercise141;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

/**
 * plan a:
 * 略暴力的解法，遍历链表并依次尝试放入不可重复的hashset中，
 * 如果添加set失败，说明出现重复添加，即链表有环，
 * 否则遍历出现空节点时，说明链表无环。
 * set: 用于存放链表节点。
 */
//class Solution {
//    public boolean hasCycle(ListNode head) {
//        Set<ListNode> set = new HashSet<>();
//        return iteratorList(set, head);
//    }
//    
//    private boolean iteratorList(Set<ListNode> set, ListNode node) {
//        if(node == null)
//            return false;
//        if(!set.add(node))
//            return true;
//        return iteratorList(set, node.next);
//    }
//}
/**
 * plan b:
 * 正常解法，通过快慢指针循环比较，如果是链表有环它们总会相遇，判断地址相等即可；
 * 如果链表没有环，那么在循环遍历中总会有取到空值的时候，为空就是无环链表了。
 * first: 表示第一个走并且走得快的指针。
 * second: 表示第二个走并且走的慢的指针。
 */
class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null)
            return false;
        
        ListNode first = head.next.next;
        ListNode second = head;
        
        while(true){
            if(first == null || first.next == null)
                return false;
            else if(first == second || first.next == second)
                return true;
            else{
                first = first.next.next;
                second = second.next;
            }
        }
    }
}

/**
 * 搞事的plan c:
 * 题目所给数据结构为单向链表，链表的next的节点只有一个，也就是形成环一定是由最后一个节点指向前面的节点。
 * 给定稍多的时间限制，使用循环遍历这个链表，以节点为null作为跳出条件，
 * 返回false，超时返回true。
 * 路子太野就不写实现了2333。
 */

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
    
    public static String booleanToString(boolean input) {
        return input ? "True" : "False";
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            ListNode head = stringToListNode(line);
            line = in.readLine();
            int pos = Integer.parseInt(line);
            
            //新语句，根据pos值添加尾节点next指向。
            setCycle(head, pos);
            //修改原语句
            boolean ret = new Solution().hasCycle(head);
            
            //原语句，方法参数不对无法运行
//            boolean ret = new Solution().hasCycle(head, pos);
            
            String out = booleanToString(ret);
            
            System.out.print(out);
        }
    }
    
    /**
     * 添加新方法，按pos为尾节点添加next节点，pos>=0添加前面的节点，pos<0则为空。
     */
    public static void setCycle(ListNode head, int pos){
        ListNode node = null;
        while(true){
            if(head == null)
                break;
            if(pos == 0)
                node = head;
            if(head.next == null){
                head.next = node;
                break;
            }
            head = head.next;
            pos--;
        }
    }
}