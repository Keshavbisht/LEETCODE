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
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        int ans = 0;
        int tempSum= 0;
        int maxi = Integer.MIN_VALUE;
        int level= 0;
        while(!q.isEmpty()){
            TreeNode temp = q.remove();
            if(temp == null){
                level++;
                if(maxi < tempSum){
                    maxi = tempSum;
                    ans = level;
                }
                if(q.isEmpty()) return ans;
                q.add(null);
                // maxi = Math.max(maxi, tempSum);
                
                tempSum = 0;
            }
            else{
                tempSum += temp.val;
                if(temp.left != null){
                    q.add(temp.left);
                }
                if(temp.right != null){
                    q.add(temp.right);
                }
            }
        }
        return ans;
    }
}