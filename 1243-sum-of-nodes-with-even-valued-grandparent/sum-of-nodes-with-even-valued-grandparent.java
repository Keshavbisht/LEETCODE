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
    public int sumEvenGrandparent(TreeNode root) {
        return helper(root, -1, -1);
    }
    public int helper(TreeNode root, int par, int gpar){
        if(root == null) return 0;

        int left = helper(root.left, root.val, par);
        int right = helper(root.right, root.val, par);

        if(gpar % 2 == 0){
            return root.val + left + right;
        }

        return left + right;
    }
}