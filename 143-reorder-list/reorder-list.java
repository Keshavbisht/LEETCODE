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
        ListNode pnt1;
        ListNode pnt2;

        ListNode curr;
        ListNode prev;
        ListNode future;

        ListNode mid;

        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        mid = slow;
        curr = slow.next;
        prev = slow;
        while(curr != null){
            future = curr.next;
            curr.next = prev;
            prev = curr;
            curr = future;
        }
        ListNode head2= prev;

        pnt1 = head;
        pnt2 = head2;

        ListNode future1;
        ListNode future2;
        while(pnt1 != mid && pnt2 != mid){
            future1 = pnt1.next;
            future2 = pnt2.next;
            pnt1.next = pnt2;
            pnt2.next = future1;
            pnt1 = future1;
            pnt2 = future2;
        }
        mid.next = null;
        

    }
}