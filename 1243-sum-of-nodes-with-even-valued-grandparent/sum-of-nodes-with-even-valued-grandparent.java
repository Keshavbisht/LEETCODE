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
    int sum1 = 0;
    public int sumEvenGrandparent(TreeNode root) {
        if(root == null) return 0;
        if(root.val %2 == 0){
            helper(root.left,0, 1);
            helper(root.right,0, 1);
        }
        else{
            helper(root.left,0, 0);
            helper(root.right,0, 0);
        }
        return sum1;
    }
    public void helper(TreeNode root, int grandParent, int parent){
        if(root == null ) return ;

        if(grandParent == 1){
            sum1 = sum1 + root.val;
        }
        if(root.val %2==0){
            helper(root.left, parent, 1);
            helper(root.right, parent, 1);
        }
        else{
            helper(root.left,  parent, 0);
            helper(root.right, parent, 0);
        }
    }
}