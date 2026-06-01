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
    public ListNode reverseEvenLengthGroups(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pnt1 = dummy;
        ListNode pnt2 = head;
        

        int prevGroup = 0;
        int currSum = 0;

        while(pnt2 != null){
            currSum++;
            if(pnt2.next == null){
                
               if(currSum % 2==0){
                    ListNode next = pnt2.next;
                    ListNode currHead = pnt1.next;

                    ListNode temp = reverse(pnt1.next, pnt2);

                    pnt1.next = temp;
                    currHead.next = next;
                }
                return dummy.next;
            }

            if(currSum > prevGroup){
                    if(currSum % 2==0){
                        ListNode next = pnt2.next;
                        ListNode currHead = pnt1.next;

                        ListNode temp = reverse(pnt1.next, pnt2);

                        pnt1.next = temp;
                        currHead.next = next;
                        pnt1 = currHead;
                        prevGroup = currSum;
                        currSum = 0;
                        pnt2 = next;
                    }
                    else{
                        pnt1 = pnt2;
                        prevGroup = currSum;
                        currSum = 0;
                        pnt2 = pnt2.next;
                    }
            }
            else{
                pnt2 = pnt2.next;
            }
            
        }
        return dummy.next;
    }
    public ListNode reverse(ListNode head, ListNode end){
        ListNode fin = end.next;
        ListNode curr = head;
        ListNode prev = null;
        ListNode future = null;

        while(curr != fin){
            future = curr.next;
            curr.next = prev;
            prev = curr;
            curr = future;
        }
        return prev;
    }
}