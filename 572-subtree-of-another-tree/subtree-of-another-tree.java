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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        return helper(root, subRoot);
    }
    public boolean helper(TreeNode root, TreeNode head){
        if(root == null) return false;
        // if(root.val == head.val) return ;

        boolean left = helper(root.left, head);
        boolean right = helper(root.right, head);

        return check(root, head) || left || right;

    }
    public boolean check(TreeNode root1, TreeNode root2){
        // if(root1.leroot2.left == null || root2.right == null) return true;
        
        if((root1 == null && root2 == null ) || (root1 == null && root2 == null)) return true;
        if(root1 == null || root2 == null) return false;
        if(root1.val != root2.val) return false;


        
        return check(root1.left, root2.left) && check(root1.right, root2.right);

        
        

        
    }
}