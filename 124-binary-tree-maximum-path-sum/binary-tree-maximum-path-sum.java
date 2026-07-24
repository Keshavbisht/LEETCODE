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
    int maxi = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        helper(root);
        return maxi;
    }
    public int helper(TreeNode root){
        if(root == null) return 0;

        int left = helper(root.left);
        int right = helper(root.right);

        int combine = left + right + root.val;
        int leftRoot = left + root.val;
        int rightRoot = right + root.val;

        maxi = Math.max(maxi,Math.max(root.val,combine));
        maxi = Math.max(maxi, Math.max(leftRoot, rightRoot));
        return Math.max(root.val, Math.max(leftRoot, rightRoot));
    }
}