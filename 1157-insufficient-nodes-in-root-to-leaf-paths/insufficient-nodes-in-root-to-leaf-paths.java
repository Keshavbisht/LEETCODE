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
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        return helper(root, limit, 0);
    }
    public TreeNode helper(TreeNode root, int limit, int count){
        if(root == null) return null;
        count = count + root.val;
        if(root.left == null && root.right == null){
            if(count>=limit) return root;
            return null;
        }
        
        root.left = helper(root.left, limit, count);
        root.right = helper(root.right, limit, count);
        if(root.left == null && root.right == null) return null;

        return root;
    }
}