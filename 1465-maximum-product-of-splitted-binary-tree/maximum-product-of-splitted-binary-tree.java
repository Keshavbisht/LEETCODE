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
    long total = 0;
    long maxi = 0;
    public int maxProduct(TreeNode root) {
        sum1(root);
        dfs(root);
        // maxi = Math.max(maxi, ((total-(a+b+root.val)) *( a+b+root.val)));
        return (int) (maxi%1000000007);
    }
    public void sum1(TreeNode root){
        if(root== null) return;
        total = total + root.val;
        sum1(root.left);
        sum1(root.right);
    }
    public long dfs(TreeNode root){
        if(root == null) return 0;

        long a = dfs(root.left);
        long b = dfs(root.right);
        maxi = Math.max(maxi, ((total-(a+b +root.val)) * (a+b+root.val)));
        return a+b+root.val;
    }
}