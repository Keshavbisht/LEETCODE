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
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int sum= 0;
        ListNode tempHead = dummy;


        while(tempHead != null){
            sum = sum + tempHead.val;
            map.put(sum, tempHead);
            tempHead =tempHead.next;
        }

        sum = 0;
        tempHead = dummy;
        while(tempHead != null){
            sum += tempHead.val;
            ListNode temp = map.get(sum);
            if(temp != tempHead){
                tempHead.next = temp.next;
            }
            tempHead = tempHead.next;
        }
        return dummy.next;
    }
}