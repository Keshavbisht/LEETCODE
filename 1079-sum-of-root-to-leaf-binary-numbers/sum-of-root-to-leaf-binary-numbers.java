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
    int ans = 0;
    public int sumRootToLeaf(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        helper(root, sb);
        return ans;
    }
    public TreeNode helper(TreeNode root, StringBuilder sb){
        if(root == null) return null;
        sb.append(root.val);
        TreeNode left = helper(root.left, sb);
        TreeNode right = helper(root.right, sb);

        if(left == null && right == null){
            int temp = Integer.parseInt(sb.toString(), 2);
            ans += temp;
        }
        sb.deleteCharAt(sb.length() - 1);

        return root;
    }
}