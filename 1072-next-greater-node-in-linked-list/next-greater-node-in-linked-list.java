/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nextLargerNodes(ListNode head) {
        // int[] ans = new int[];
        Stack<Integer> st = new Stack<>();
        ListNode temp = head;
        int i = 0;

        while(temp != null){
            temp = temp.next;
            i++;
        }
        int n = i;
        int[] ans = new int[i];
        Arrays.fill(ans,-1);
        ListNode prev =null;
        ListNode future;
        ListNode curr = head;
        while(curr != null){
            future = curr.next;
            curr.next = prev;
            prev = curr;
            curr = future;
        }
        temp = prev;
        i = n-1;
        while(temp != null){
            
            while(!st.isEmpty() && temp.val >= st.peek()){
                    st.pop();
            }
            if(!st.isEmpty()){
                ans[i] = st.peek();
            }
            else{
                ans[i] = 0;
            }
            
            st.add(temp.val);
            temp = temp.next;
            i--;

        }
        return ans;
    }
}