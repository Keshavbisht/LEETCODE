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
    public ListNode removeNodes(ListNode head) {
        int maxi = 0;

        ListNode temp;
        ListNode curr= head;
        ListNode prev= null;
        ListNode future = null;

        while(curr != null){
            future = curr.next;
            curr.next = prev;
            prev = curr;
            curr = future;
        }
        head = prev;
        temp = prev;
        prev = null;
        while(temp != null){
            if(maxi <= temp.val){
                maxi = temp.val;
                prev = temp;
            }
            else{
                prev.next = temp.next;
            }
            temp = temp.next;
        }

        curr = head;
        prev = null;
        future = null;
        while(curr != null){
            future = curr.next;
            curr.next = prev;
            prev = curr;
            curr = future;
        }
        return prev;
    }
}