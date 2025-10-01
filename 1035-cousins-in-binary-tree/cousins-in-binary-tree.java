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
class tuple {
    TreeNode parent;
    int level;
    TreeNode current;
    tuple(TreeNode current, TreeNode parent, int level){
        this.current = current;
        this.parent = parent;
        this.level = level;
    }
}

class Solution {
    int level = 0;

    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<tuple> q = new LinkedList<>();
        tuple foundX = null;
        tuple foundY = null;
        
        q.add(new tuple(root, null, 0));
        q.add(null);

        while (!q.isEmpty()) {
            if (foundX != null && foundY != null) {
                if (foundX.level != foundY.level) return false;
                if (foundX.parent == foundY.parent) return false;
                return true;
            }

            tuple curr = q.remove();

            if (curr == null) {
                if (q.isEmpty()) return false;
                else {
                    level++;
                    q.add(null);
                }
            } else {
                if (curr.current.val == x) {
                    foundX = curr;
                } else if (curr.current.val == y) {
                    foundY = curr;
                }

                if (curr.current.left != null) {
                    q.add(new tuple(curr.current.left, curr.current, curr.level + 1));
                }
                if (curr.current.right != null) {
                    q.add(new tuple(curr.current.right, curr.current, curr.level + 1));
                }
            }
        }
        return false;
    }
}
