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
    int k=0;
    public TreeNode bstToGst(TreeNode root) {
        List<Integer> arr = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();
        dfs(root, arr);
        int sum1= 0;
        for(int i = 0; i< arr.size(); i++){
            sum1 = sum1 + arr.get(i);
        }
        arr2.add(sum1);
        for(int i = 1; i< arr.size(); i++){

            arr2.add(sum1 - arr.get(i-1) );
            sum1 = sum1 - arr.get(i-1);

        }
        // for (int num : arr2) {
        //     System.out.print(num + " ");
        // }
        helper(root, arr2);
        return root;



    }
    public void dfs(TreeNode root, List<Integer> arr){
        if(root == null) return ;

        dfs(root.left, arr);
        arr.add(root.val);
        dfs(root.right, arr);
    }
    public void helper(TreeNode root, List<Integer> arr2){
        if(root == null) return ;

        helper(root.left, arr2);
        root.val = arr2.get(k);
        k++;
        helper(root.right, arr2);
    }
}