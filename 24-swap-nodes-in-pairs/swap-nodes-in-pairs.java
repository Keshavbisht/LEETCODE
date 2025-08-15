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
    public ListNode swapPairs(ListNode head) {
        if(head == null) return null;
        ListNode temp1 = head;
        ListNode temp2 = head.next;

        while(temp2 != null){
            int x = temp1.val;
            temp1.val = temp2.val;
            temp2.val = x;
            if(temp1.next.next == null ||temp2.next.next == null ) return head;
            temp1= temp1.next.next;
            temp2 = temp2.next.next;
        }
        return head;
    }
}