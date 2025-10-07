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
    public int pairSum(ListNode head) {
        ListNode mid;
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        mid = slow;
        ListNode head2 = reverse(mid);
        ListNode temp =head;
        ListNode temp2 = head2;
        int maxi = Integer.MIN_VALUE;

        while(temp != mid && temp2 != null){
            maxi = Math.max(maxi, temp.val+temp2.val);
            temp = temp.next;
            temp2 = temp2.next;
        }
        return maxi;
    }
    public ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        ListNode future;

        while(curr != null){
            future = curr.next;
            curr.next = prev;
            prev = curr;
            curr = future;
        }
        return prev;
    }
}