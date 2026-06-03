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
class Tuple{
    int val;
    int maxi = 0;
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    int currSum = 0;
    boolean flag = true;
    Tuple(){
        this.val = 0;
        // int lMax = Integer.MIN_VALUE;;
        // int rMin = Integer.MAX_VALUE;
        // int currSum = 0;
        // boolean flag = true;
    }
    Tuple(int val){
        this.val = val;
    }
}
class Solution {
    public int maxSumBST(TreeNode root) {
        Tuple temp = helper(root);
        return temp.maxi;
    }
    public Tuple helper(TreeNode root){
        if(root == null) return new Tuple();

        Tuple curr = new Tuple(root.val);

        Tuple left = helper(root.left);
        Tuple right = helper(root.right);

        if(left.flag == false || right.flag == false || left.max >= curr.val || right.min <= curr.val){
            curr.flag = false;
            curr.maxi = Math.max(right.maxi, left.maxi);
            return curr;
        }

        curr.currSum = curr.val + left.currSum + right.currSum;
        curr.maxi = Math.max(curr.currSum, Math.max(left.maxi, right.maxi));

        curr.min = Math.min(curr.val, left.min);
        curr.max = Math.max(curr.val, right.max);
        return curr;

    }
}