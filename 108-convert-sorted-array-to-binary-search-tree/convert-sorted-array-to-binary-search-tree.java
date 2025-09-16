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
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(0, nums.length-1, nums);
    }
    public TreeNode helper(int a, int b, int[] nums){
        if(b<a || a>b) return null;
        int mid = (a+b)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(a,mid-1, nums);
        root.right = helper(mid+1, b, nums);

        return root;
    }
}