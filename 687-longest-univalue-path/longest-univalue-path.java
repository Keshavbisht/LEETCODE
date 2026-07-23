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
    int maxi = 0;
    public int longestUnivaluePath(TreeNode root) {
        if(root == null) return 0;
        longestUnivaluePath(root.left);
        longestUnivaluePath(root.right);
        helper(root, root.val);
        return maxi;
    }
    public int helper(TreeNode root, int par){
        if(root == null || root.val != par) return 0;

        int left = helper(root.left, par);
        int right = helper(root.right, par);
        maxi = Math.max(maxi, left+right);
        return Math.max(left, right)+1;

    }
}