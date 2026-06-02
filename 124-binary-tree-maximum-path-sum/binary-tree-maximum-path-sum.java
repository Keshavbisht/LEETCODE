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
    int maxi= Integer.MIN_VALUE;    
    public int maxPathSum(TreeNode root) {
        helper(root);
        return maxi;
    }
    public int helper(TreeNode root){
        if(root == null) return 0;


        int left = helper(root.left);
        int right = helper(root.right);

        int all = left+right+root.val;
        int onlyLeft = left + root.val;
        int onlyRight = right + root.val;



        maxi = Math.max(maxi, Math.max(all, Math.max(onlyLeft, onlyRight)));
        maxi = Math.max(maxi, root.val);

        return Math.max(root.val, Math.max(onlyLeft, onlyRight));
    }
}