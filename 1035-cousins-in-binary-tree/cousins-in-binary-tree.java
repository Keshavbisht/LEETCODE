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
        int level = 0;
        q.add(new Tuple(root, null, level));
        q.add(null);
        Tuple t1 = null;
        Tuple t2 = null;

        while(!q.isEmpty()){
            Tuple curr = q.remove();
            if(curr == null){
                if(t1 != null && t2 != null){
                    if((t1.level == t2.level) && (t1.par.val != t2.par.val)) return true;
                   
                }
                if(t1 != null || t2 != null) return false;
                if(q.isEmpty()) return false;
                q.add(null);
                level++;
                continue;
            }
            else{
                if(curr.root.val == x){
                    t1 = curr;
                }
                if(curr.root.val == y){
                    t2 = curr;
                }
                if(curr.root.left != null){
                    q.add(new Tuple(curr.root.left, curr.root, level));
                }
                if(curr.root.right != null){
                    q.add(new Tuple(curr.root.right, curr.root, level));
                }
            }
            
        }
        return false;
    }
    
}