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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(-1);
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val );

        for(ListNode it: lists){
            if(it !=null){
                pq.add(it);
            }
        }
        ListNode curr = dummy;
        while(!pq.isEmpty()){
            ListNode temp = pq.remove();
            curr.next = temp;
            curr = curr.next;
            if(temp.next != null){
                pq.add(temp.next);
            }
        }

        return dummy.next;

    }
}