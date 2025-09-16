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
    int data;
    int currSum;
    int LMax;
    int RMin;
    boolean flag;
    Tuple(){
        data = 0;
        currSum = 0;
        LMax = Integer.MIN_VALUE;
        RMin = Integer.MAX_VALUE;
        flag = true;
    }
    Tuple(int x){
        this.data = x;
        currSum = 0;
        LMax = Integer.MIN_VALUE;
        RMin = Integer.MAX_VALUE;
        flag = true;
    }

}
class Solution {
    int maxi = 0;
    public int maxSumBST(TreeNode root) {
        helper(root);
        return maxi;
        
    }
    public Tuple helper(TreeNode root){
        if(root == null) return new Tuple();
        
        Tuple curr = new Tuple(root.val);


        Tuple left = helper(root.left);
        Tuple right = helper(root.right);
        if(!left.flag || !right.flag ||left.LMax >= root.val || right.RMin <= root.val){
            curr.flag = false;
            return curr;
        }
        curr.currSum = left.currSum + right.currSum + root.val;
        maxi = Math.max(maxi, curr.currSum);
        curr.LMax = Math.max(right.LMax, root.val);
        curr.RMin = Math.min(left.RMin, root.val);

        return curr;

    }
}