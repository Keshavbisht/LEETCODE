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
        
        ListNode pnt1 = head;
        ListNode pnt2 = head.next;

        int sum = 0;

        while(pnt2 != null){
            if(pnt2.val != 0){
                sum += pnt2.val;
            }
            else if(pnt2.next == null){
                pnt1.val = sum;
                pnt1.next = null;
            }
            else{
                pnt1.val = sum;
                sum = 0;
                pnt1.next = pnt2;
                pnt1 = pnt1.next;
            }
            pnt2 = pnt2.next;
        }
        
        return head;
    }
}