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
    public int findBottomLeftValue(TreeNode root) {
        int ans = Integer.MIN_VALUE;
        if(root.left == null && root.right == null) return root.val;
        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);
        q.add(null);
        int maxi = Integer.MIN_VALUE;
        while(!q.isEmpty()){
            TreeNode curr = q.remove();
            if(curr == null){
                if(q.isEmpty()){
            
                    return ans;
                }
                else{
                    ans = q.peek().val;
                    q.add(null);
                }
            }
            else{
                
                if(curr.left != null){
                    q.add(curr.left);
                }
                if(curr.right != null){
                    q.add(curr.right);
                }
            }
            
        }
        return ans;
        
    }
}