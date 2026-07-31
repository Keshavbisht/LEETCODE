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
    public int helper(TreeNode root, int parent, int grandParent){
        if(root == null) return 0;

        int left = helper(root.left, root.val, parent);
        int right = helper(root.right, root.val, parent);

        if(grandParent % 2 == 0){
            return root.val + left+right;
        }
        return left+right;
    }
}