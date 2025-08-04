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
    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> arr = new HashSet<>();
        return helper(root, arr, k);
    }
    public boolean helper(TreeNode root, HashSet<Integer> arr, int k){
        if(root == null) return false;
        if(arr.contains(k-root.val)) return true;
        arr.add(root.val);
        
        return helper(root.left, arr, k) | helper(root.right, arr, k);
    }
}