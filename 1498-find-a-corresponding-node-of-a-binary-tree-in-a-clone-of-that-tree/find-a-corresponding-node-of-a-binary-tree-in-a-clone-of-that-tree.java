/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        return DFS(original, cloned, target);
    }
    public TreeNode DFS(TreeNode original,TreeNode cloned,TreeNode target){
        if(cloned == null) return null;
        if(cloned.val == target.val) return cloned;
        TreeNode leftResult = DFS(original, cloned.left, target);
        if (leftResult != null) return leftResult;
    
        TreeNode rightResult = DFS(original, cloned.right, target);
        if (rightResult != null) return rightResult;
        return null;
        
    }
    
}