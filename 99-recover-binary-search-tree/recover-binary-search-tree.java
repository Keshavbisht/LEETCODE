import java.util.*;
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
    public void recoverTree(TreeNode root) {
        
        List<Integer> arr = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();
        inOrder(root, arr, arr2);
        Collections.sort(arr2);
        int temp1 = 0;
        int temp2 = 0;

        for(int i = 0; i<arr.size();i++){
            if(!arr.get(i).equals( arr2.get(i))){
                if(temp1 == 0){
                    temp1 = arr.get(i);
                }
                else{
                    temp2 = arr.get(i);
                }
            }
        }
        helper(root, temp1, temp2);
        System.out.println(temp1);
    }
    public void inOrder(TreeNode root, List<Integer> arr, List<Integer> arr2){
        if(root==null) return;

        inOrder(root.left, arr, arr2);
        arr.add(root.val);
        arr2.add(root.val);
        inOrder(root.right, arr, arr2);
        
    }
    public void helper(TreeNode root, int temp1, int temp2){
        if(root == null) return;

        if(root.val == temp1){
            root.val = temp2;
        }
        else if(root.val == temp2){
            root.val = temp1;
        }
        helper(root.left, temp1, temp2);
        helper(root.right, temp1, temp2);
    }
}