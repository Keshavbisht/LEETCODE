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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode head2;
        ListNode dummy = new ListNode(-1);
        head2 = dummy;
        dummy.next = head;
        ListNode pnt1 = dummy;
        ListNode pnt2 = head;
        int count = 0;

        while(pnt2 != null){

            count+=1;
            if(count == k){
                System.out.println("hi");
                ListNode future = pnt2.next;
                ListNode pre = pnt1.next;
                ListNode temp = reverse(pre, pnt2);
                System.out.println("hi --");
                if(head2 == dummy){
                    head2= temp;

                }

                pre.next = future;
                
                pnt1.next = temp;
                pnt1 = pre;
                pnt2 = pre;
                count = 0;
            }
            pnt2= pnt2.next;
        }
        return dummy.next;
    }

    public ListNode reverse(ListNode head, ListNode end) {
        ListNode stop = end.next;
        ListNode prev = null;
        ListNode curr = head;

        while (curr != stop) {
            ListNode future = curr.next;
            curr.next = prev;
            prev = curr;
            curr = future;
        }

        return prev;
    }

}