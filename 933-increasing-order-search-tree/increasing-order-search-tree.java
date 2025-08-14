class Solution {
    Stack<TreeNode> st = new Stack<>();
    
    public TreeNode increasingBST(TreeNode root) {
        helper(root);

        TreeNode head = st.pop();
        TreeNode curr = head;

        while (!st.isEmpty()) {
            TreeNode next = st.pop();
            next.left = null;
            next.right = null; 
            curr.right = next;
            curr = next;
        }
        return head;
    }

    public void helper(TreeNode root) {
        if (root == null) return;
        helper(root.right);
        st.push(root);
        helper(root.left);
    }
}
