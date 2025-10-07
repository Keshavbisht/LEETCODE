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
    public int goodNodes(TreeNode root) {
        helper(root, root.val);
        return ans;
    }
    public void helper(TreeNode root, int maxi){
        if(root == null) return;

        if(root.val >= maxi){
            maxi = root.val;
            ans++;
        }
        helper(root.left, maxi);
        helper(root.right, maxi);
        return;
    }
}