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
    boolean flag = false;
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if(root.val == target && root.left==null && root.right==null) return null;
        helper(root, target);
        while(flag == true){
            if(root.val == target && root.left==null && root.right==null) return null;
            flag = false;
            helper(root, target);
        }
        return root;
        
    }
    public TreeNode helper(TreeNode root, int target){
        if(root == null) return null;
        if(root.val == target && root.left== null && root.right == null){
            flag = true;
            return null;
        }
        root.left = helper(root.left, target);
        root.right = helper(root.right, target);

        return root;

    }
}