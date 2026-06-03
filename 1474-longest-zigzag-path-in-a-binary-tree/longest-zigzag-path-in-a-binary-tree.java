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
    public int longestZigZag(TreeNode root) {
        if(root.left == null && root.right == null) return 0;
        return Math.max(helper(root.left, 0, 1), helper(root.right, 1,1));
    }
    public int helper(TreeNode root, int direction, int ans){
        if(root == null) return ans-1;
        int a = 0;
        int b= 0;
        if(direction == 0){
            a = helper(root.right, 1, ans+1);
            b = helper(root.left, 0, 1);
        }
        else{
            a = helper(root.left, 0, ans+1);
            b = helper(root.right, 1, 1);
        }
        

        return Math.max(ans,Math.max(a, b));
    }
}