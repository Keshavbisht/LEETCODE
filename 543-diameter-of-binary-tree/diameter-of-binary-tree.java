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
    int maxi =0;
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return maxi;
    }
    public int height(TreeNode root){
        if(root == null) return 0;
        
        int left = height(root.left);
        int right = height(root.right);

        maxi = Integer.max(maxi, left + right);

        return 1 + Integer.max(left, right);
    }
}