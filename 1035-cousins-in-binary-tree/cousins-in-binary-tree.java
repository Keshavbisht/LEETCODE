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
    class Tuple{
        TreeNode root;
        TreeNode par;
        int level;
        Tuple(TreeNode root, TreeNode par, int level){
            this.root = root;
            this.par = par;
            this.level = level;
        }
    }
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<Tuple> q = new LinkedList<>();

        q.add(new Tuple(root, null, 0));
        q.add(null);

        Tuple x1 = null;
        Tuple y1 = null;

        while(!q.isEmpty()){
            Tuple curr = q.remove();

            if(curr == null){
                if(x1 != null && y1 == null) return false;
                if(y1!= null && x1 == null) return false;
                if(x1 != null && y1 != null){
                    if(x1.par != y1.par) return true;
                }
                if(q.isEmpty()) return false;
                q.add(null);
            }
            else{
                if(curr.root.val == x){
                    x1 = curr;
                }
                if(curr.root.val == y){
                    y1 = curr;
                }
                if(curr.root.left != null){
                    q.add(new Tuple(curr.root.left, curr.root, curr.level+1));
                }
                if(curr.root.right != null){
                    q.add(new Tuple(curr.root.right, curr.root, curr.level+1));
                }
            }
        }
        return false;
    }
}