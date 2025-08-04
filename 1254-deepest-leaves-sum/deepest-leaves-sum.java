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
    public int deepestLeavesSum(TreeNode root) {
        return bfs(root);
    }
    public int bfs(TreeNode root){
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        int sum1 = 0;
        while(!q.isEmpty()){
            TreeNode curr = q.remove();

            if(curr == null){
                if(q.isEmpty()){
                    return sum1;
                }
                else{
                    q.add(null);
                    sum1 = 0;
                }
            }
            else{
                sum1 = sum1 + curr.val;
                if(curr.left != null){
                    q.add(curr.left);
                }
                if(curr.right != null){
                    q.add(curr.right);
                }
            }
        }
        return sum1;
    }
}