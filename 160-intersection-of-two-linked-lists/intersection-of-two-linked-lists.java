/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Stack<ListNode> a = new Stack<>();
        Stack<ListNode> b = new Stack<>();

        ListNode temp = headA;
        while(temp != null){
            a.push(temp);
            temp = temp.next;
        }
        temp = headB;
        while(temp != null){
            b.push(temp);
            temp = temp.next;
        }

        ListNode prev = null;
        while(!a.isEmpty() && !b.isEmpty() && a.peek() == b.peek()){
            prev = a.peek();
            a.pop();
            b.pop();
        }
        return prev;
    }
}