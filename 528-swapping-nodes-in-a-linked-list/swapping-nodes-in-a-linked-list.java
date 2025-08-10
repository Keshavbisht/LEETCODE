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
    public ListNode swapNodes(ListNode head, int k) {
        int n = 0;
        ListNode temp = head;
        while(temp != null){
            temp =temp.next;
            n++;
            
        }
        
        int i1 = k-1;
        int i2 = n-k;
        ListNode num1 = null;
        ListNode num2= null;
        temp = head;
        for(int i = 0; i< n; i++){
            if(i == i1){
                num1 = temp;
            }
            if(i == i2){
                num2 = temp;
            }
            temp = temp.next;
        }
        int t = num1.val;
        num1.val = num2.val;
        num2.val =t;
        return head;
    }
}