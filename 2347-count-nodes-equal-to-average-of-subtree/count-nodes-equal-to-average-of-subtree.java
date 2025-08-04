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
    int ans =0;
    public int averageOfSubtree(TreeNode root) {
        if(root == null) return 0;
        int c = count(root);
        int sum = helper(root);

        if(sum/c == root.val){
            ans++;
        }
        averageOfSubtree(root.left);
        averageOfSubtree(root.right);
        return ans;
    }
    public int count(TreeNode root){
        if(root == null) return 0;

        int left = count(root.left);
        int right = count(root.right);
       
        return left + right +1;
    }
    public int helper(TreeNode root){
        if(root == null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);

        return left + right + root.val;

    }
}