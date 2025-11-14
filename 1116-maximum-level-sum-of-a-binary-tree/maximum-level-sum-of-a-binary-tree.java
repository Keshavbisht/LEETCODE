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
    int[] ans = new int[2];
    
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        ans[1] = Integer.MIN_VALUE;
        q.add(root);
        q.add(null);
        int sum1 = 0;
        int level = 1;

        while(!q.isEmpty()){
            TreeNode curr = q.remove();
            if(curr == null){
                
                if(ans[1] < sum1){
                    ans[0] = level;
                    ans[1] = sum1;
                }
                if(q.isEmpty()) return ans[0];
                sum1 = 0;
                level++;
                q.add(null);
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
        return ans[0];


    }
}