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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode temp = list1;

        ListNode pointer1 = null;
        ListNode pointer2 = null;

        int i=-1;

        while(temp!=null){
            i++;
            if(i == a-1){
                pointer1 = temp;
            }
            if(i == b){
                pointer2 = temp.next;
            }
            temp = temp.next;
            
        }
        pointer1.next = list2;
        temp = list2;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = pointer2;
        return list1;


    }
}