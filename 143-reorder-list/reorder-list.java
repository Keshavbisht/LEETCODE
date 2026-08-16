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

        while(fast != null && fast.next != null ){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow;

        ListNode head2 = reverse(slow, null);

        ListNode temp1 = head;
        ListNode temp2 = head2;
        while(temp2 != mid && temp1 != mid){
            ListNode future1 = temp1.next;
            ListNode future2 = temp2.next;

            temp1.next = temp2;
            temp2.next = future1;
            temp1 = future1;
            temp2 = future2;
        }
        

    }
    public ListNode reverse(ListNode head, ListNode stop){
        ListNode curr = head;
        ListNode prev = null;
        
        while(curr != stop){
            ListNode future = curr.next;

            curr.next = prev;
            prev = curr;
            curr = future;
        }
        return prev;

    }
}