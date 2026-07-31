/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    String ans = null;
    public String smallestFromLeaf(TreeNode root) {
        helper(root, new StringBuilder());
        return ans;
    }
    public void helper(TreeNode root, StringBuilder sb){
        if(root == null) return;
        sb.append(String.valueOf((char) ('a' + root.val)));
        if(root.left ==null && root.right == null){
            String curr = sb.reverse().toString();
            sb.reverse();
            if(ans == null || curr.compareTo(ans) < 0){
                ans = curr;
            } 
        }
        helper(root.left, sb);
        helper(root.right, sb);
        sb.deleteCharAt(sb.length()-1);
        return;
    }
}
