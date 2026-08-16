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
    Queue<TreeNode> q;
    public void flatten(TreeNode root) {
        q = new LinkedList<>(); 
        helper(root);
        // TreeNode prev = null;
        while(!q.isEmpty()){
            TreeNode curr = q.remove();
            if(q.isEmpty()){
                curr.left = null;
                curr.right = null;
                break;
            }
            curr.right = q.peek();
            curr.left = null;
            
        }
        // return root;

    }
    public void helper(TreeNode root){
        if(root == null) return;

        q.add(root);
        helper(root.left);
        helper(root.right);
    }
    
}