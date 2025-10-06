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
    int ans = Integer.MIN_VALUE;
    public int maxAncestorDiff(TreeNode root) {
        helper(root, root.val, root.val);
        return ans;
        
    }
    public void helper(TreeNode root, int mini, int maxi){
        if(root == null) return;
        if(root.val < mini) {
            mini = root.val;
        }
        else if(root.val > maxi){
            maxi = root.val;
        }
        helper(root.left, mini, maxi);
        helper(root.right, mini, maxi);
        ans = Math.max(ans, Math.abs(maxi - mini));


    }
}