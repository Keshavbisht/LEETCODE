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
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast!= null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow;

        ListNode curr = slow;
        ListNode prev = null;

        while(curr != null){
            ListNode future = curr.next;

            curr.next = prev;
            prev = curr;
            curr = future;
        }

        ListNode head2 = prev;
        ListNode temp1 = head;
        ListNode temp2 = head2;

        while(temp1 != mid && temp2 != mid){
            ListNode future1 = temp1.next;
            ListNode future2 = temp2.next;

            temp1.next = temp2;
            temp2.next = future1;

            temp1 = future1;
            temp2 = future2;
        }
        

    }
}