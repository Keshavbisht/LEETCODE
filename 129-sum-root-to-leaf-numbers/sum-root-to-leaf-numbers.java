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
    int ans = 0;
    public int sumNumbers(TreeNode root) {
        helper(root, "");
        return ans;
    }
    public void helper(TreeNode root, String str){
        if(root == null) return;
        if(root.left == null && root.right == null){
            str = str+ String.valueOf(root.val);
            ans += Integer.parseInt(str);
        }
        // System.out.println(str+ String.valueOf(root.val));
        helper(root.left, str + String.valueOf(root.val));
        helper(root.right, str+ String.valueOf(root.val));
        return;
    }
}