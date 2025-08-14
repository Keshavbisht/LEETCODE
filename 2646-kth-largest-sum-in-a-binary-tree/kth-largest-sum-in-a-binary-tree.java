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
    public long kthLargestLevelSum(TreeNode root, int k) {
        Queue<TreeNode> q = new LinkedList<>();
        List<Long> arr = new ArrayList<>();
        q.add(root);
        q.add(null);
        long sum1 = 0;

        while(!q.isEmpty()){
            TreeNode curr = q.remove();

            if(curr == null){
                if(q.isEmpty()){
                    arr.add(sum1);
                    break;
                }
                else{
                    q.add(null);
                    arr.add(sum1);
                    sum1 = 0;
                }
                
            }
            else{
                sum1 += curr.val;
                if(curr.left != null){
                    q.add(curr.left);
                }
                if(curr.right != null){
                    q.add(curr.right);
                }
            }
        }
        if (k > arr.size()) return -1;
        Collections.sort(arr, Collections.reverseOrder());
        
        return arr.get(k-1);
    }

}