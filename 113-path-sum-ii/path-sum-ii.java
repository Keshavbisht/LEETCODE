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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        helper(root, targetSum, 0, ans, temp);
        return ans;


    }
    public void helper(TreeNode root, int targetSum, int currSum,List<List<Integer>> ans, List<Integer> temp){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null && currSum+root.val == targetSum){
            temp.add(root.val);
            ans.add(new ArrayList<>(temp));
            temp.remove(temp.size()-1);
            return;
        }
        temp.add(root.val);
        helper(root.left, targetSum, currSum + root.val, ans, temp);
        // temp.remove(temp.size()-1);
        helper(root.right, targetSum, currSum + root.val, ans ,temp);
        temp.remove(temp.size()-1);
    }
}