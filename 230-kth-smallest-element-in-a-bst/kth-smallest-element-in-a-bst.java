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
    int curr = 0;
    public int kthSmallest(TreeNode root, int k) {
        curr = k;
        TreeNode curr = helper(root, k);
        return curr.val;
    }
    public TreeNode helper(TreeNode root, int k){
        if(root == null) return null;

        TreeNode left = helper(root.left, k);
        curr = curr-1;
        if(left != null) return left;
        if(curr == 0) return root;
        System.out.println(root.val);
        TreeNode right = helper(root.right, k);
        if(right != null) return right;
        
        return null;
    }
}