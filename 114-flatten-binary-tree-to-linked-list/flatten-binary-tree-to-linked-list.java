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
    Queue<TreeNode> q =new LinkedList<>();
    public void flatten(TreeNode root) {
        dfs(root);

        while(!q.isEmpty()){
            TreeNode temp = q.remove();
            temp.left = null;
            temp.right = q.peek();
        }
    }
    public void dfs(TreeNode root){
        if(root == null) return;
        q.add(root);
        dfs(root.left);
        dfs(root.right);
    }
    
}