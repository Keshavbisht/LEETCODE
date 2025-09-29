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
    public ListNode removeZeroSumSublists(ListNode head) {
        HashMap<Integer, ListNode> map = new HashMap<>();
        int prefix = 0;
        ListNode temp = head;
        while(temp != null){
            prefix = prefix + temp.val;
            if(prefix == 0){
                head = temp.next;
            }
            map.put(prefix, temp);
            temp = temp.next;
        }

        temp = head;
        prefix = 0;
        while(temp!= null){
            prefix = prefix + temp.val;
            if(map.containsKey(prefix)){
                temp.next = map.get(prefix).next;
            }
            temp = temp.next;
        }
        return head;
    }
}