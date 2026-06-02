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
    int[] ans = new int[]{-1,-1};
    public int findBottomLeftValue(TreeNode root) {
        helper(root, 1,0 );
        return ans[0];
    }
    public void helper(TreeNode root, int side, int level){
        if(root == null) return;

        
        if(level > ans[1]){
            ans[0] = root.val;
            ans[1] = level;
        }
        

        helper(root.left, 1, level+1);
        helper(root.right, 0, level+1);
    }
}