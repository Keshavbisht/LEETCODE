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
    public ListNode rotateRight(ListNode head, int k) {
        int n = 1;
        if(head == null) return null;
        ListNode temp = head;

        while(temp.next != null){
            n++;
            temp = temp.next;
        }
        temp.next = head;

        k = k % n;
        temp = head;
        for(int i = 1; i<n-k; i++){
            temp = temp.next;
        }
        head= temp.next;
        temp.next = null;
        return head;
    }
}