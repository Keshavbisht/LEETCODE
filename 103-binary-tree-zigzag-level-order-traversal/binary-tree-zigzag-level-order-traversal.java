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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);
        q.add(null);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        if(root == null) return ans;
        int a = 1;
        while(!q.isEmpty()){
            TreeNode curr = q.remove();
            if(curr == null){
                if(a % 2 == 0){
                    Collections.reverse(temp);
                    ans.add(temp);
                }
                else{
                    ans.add(temp);
                }
                temp = new ArrayList<>();
                if(q.isEmpty()) return ans;
                q.add(null);
                a++;
            }
            else{
                temp.add(curr.val);
                if(curr.left!= null){
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