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
        dfs(root);
        q.add(null);
        while(!q.isEmpty() && q.peek() != null){
            TreeNode curr = q.remove();
            curr.left = null;
            curr.right = q.peek();
        }
    }
    public void dfs(TreeNode root){
        if(root == null) return;

        q.add(root);
        dfs(root.left);
        dfs(root.right);
    }
}