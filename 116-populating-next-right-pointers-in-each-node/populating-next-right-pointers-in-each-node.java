/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        Queue<Node> q = new LinkedList<>();
        if(root == null) return root;

        q.add(root);
        q.add(null);
        // Node prev = null;

        while(!q.isEmpty()){
            Node curr = q.remove();
            // if(curr)
            // if(prev = null){
            //     prev = c
            // }
            if(curr == null){
                if(q.isEmpty()) return root;
                q.add(null);
            }
            // prev.next = curr;
            else{
                // prev.next = curr;
                curr.next = q.peek();
                if(curr.left != null){
                    q.add(curr.left);
                }
                if(curr.right != null){
                    q.add(curr.right);
                }
            }
            // prev= curr;
            
        }
        return root;
    }
    
}