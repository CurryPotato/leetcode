package exercise108;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return ToTree(nums, 0, nums.length - 1);
    }

    private TreeNode ToTree(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int middle = left + (right - left) / 2;
        TreeNode node = new TreeNode(nums[middle]);
        node.left = ToTree(nums, left, middle - 1);
        node.right = ToTree(nums, middle + 1, right);
        return node;
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
    
    public static String treeNodeToString(TreeNode root) {
        if (root == null) {
            return "[]";
        }
    
        String output = "";
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        while(!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();
    
            if (node == null) {
              output += "null, ";
              continue;
            }
    
            output += String.valueOf(node.val) + ", ";
            nodeQueue.add(node.left);
            nodeQueue.add(node.right);
        }
        return "[" + output.substring(0, output.length() - 2) + "]";
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] nums = stringToIntegerArray(line);
            
            TreeNode ret = new Solution().sortedArrayToBST(nums);
            
            String out = treeNodeToString(ret);
            
            System.out.print(out);
        }
    }
}
