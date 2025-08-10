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
    public ListNode mergeNodes(ListNode head) {
        int sum1 = 0;
        ListNode head2 = new ListNode(0);
        ListNode temp2 = head2;
        ListNode temp = head.next;
        ;
        while (temp != null) {

            if (temp.val == 0) {
                if (head2.val == 0) {
                    temp2.val = sum1;
                    sum1 = 0;
                    
                } 
                else {
                    ListNode curr = new ListNode(sum1);
                    temp2.next = curr;
                    temp2 = temp2.next;
                    sum1 = 0;
                    
                }
            }
            if (temp.val != 0) {
                sum1 += temp.val;
            }
            temp = temp.next;
        }
        return head2;
    }
}