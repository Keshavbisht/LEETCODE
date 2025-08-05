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
    int level = 0;
    public boolean isEvenOddTree(TreeNode root) {
        return bfs(root);
    }
    public boolean bfs(TreeNode root){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        int prev = Integer.MIN_VALUE;

        while(!q.isEmpty()){
            TreeNode curr = q.remove();

            if(curr == null){
                if(q.isEmpty()){
                    return true;
                }
                else{
                    level++;
                    prev = (level % 2 == 0) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                    q.add(null);
                }
            }
            else{
                if(level%2==0){
                    if(curr.val %2 ==0) return false;
                    if(curr.val <= prev) return false;
                }
                else{
                    if(curr.val %2 !=0) return false;
                    if(curr.val >= prev) return false;
                }
                prev = curr.val;
                if(curr.left != null){
                    q.add(curr.left);

                }
                if(curr.right != null){
                    q.add(curr.right);
                }
            }
        }
        return true;
    }
}