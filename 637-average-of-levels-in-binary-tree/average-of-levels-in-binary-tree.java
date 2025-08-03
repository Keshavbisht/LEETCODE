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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<>();
        bfs(root, ans);
        return ans;
    }
    public void bfs(TreeNode root, List<Double> ans){
        Queue<TreeNode> q = new LinkedList<>();
        int count = 0;
        double sum1 = 0;
        q.add(root);
        q.add(null);

        while(!q.isEmpty()){
            TreeNode curr = q.remove();

            if(curr == null){
                if(q.isEmpty()){
                    ans.add(sum1/count);
                    q.add(null);
                    return;
                }
                else{
                    ans.add(sum1/count);
                    q.add(null);
                    count = 0;
                    sum1 = 0;
                }
            }
            else{
                sum1 = sum1 + curr.val;
                count++;
                if(curr.left != null){
                    q.add(curr.left);
                }
                if(curr.right != null){
                    q.add(curr.right);
                }
            }
        }
        return;
    }
}