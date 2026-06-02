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
    int ans;
    public int goodNodes(TreeNode root) {
        return helper(root, root.val);
    }
    public int helper(TreeNode root, int maxi){
        if(root == null) return 0;

        if(root.val >= maxi){
            ans++;
            maxi = root.val;
        }

        helper(root.left, maxi);
        helper(root.right, maxi);

        return ans;
    }
}