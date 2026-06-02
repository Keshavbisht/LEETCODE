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
    public int sumEvenGrandparent(TreeNode root) {
        helper(root, 0, 0);
        return ans;
    }

    public void helper(TreeNode root, int gParent, int parent){
        if(root == null) return;

        if(gParent == 1){
            ans += root.val;
        }

        if(root.val %2 == 0){
            helper(root.left, parent, 1);
            helper(root.right, parent, 1);
        }
        else{
            helper(root.left, parent, 0);
            helper(root.right, parent, 0);
        }

    }
}