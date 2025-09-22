/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;

        Node temp = head;
        
        while(temp != null){
            Node curr = new Node(temp.val);
            curr.next = temp.next;
            temp.next = curr;
            temp = curr.next;
        }

        Node head2 = new Node(-1);
        head2.next = head.next;
        temp = head;
        Node temp2 = head2.next;

        
        while(temp != null){
            if(temp.random == null){
                temp2.random = null;
            } else{
                temp2.random = temp.random.next;
            }
            temp = temp.next.next;
            temp2 = temp2.next != null ? temp2.next.next : null;
        }

        
        temp = head;
        temp2 = head2.next;
        while(temp != null && temp2 != null){
            temp.next = temp.next.next;
            temp = temp.next;
            if(temp2.next != null){
                temp2.next = temp2.next.next;
                temp2 = temp2.next;
            }
        }

        return head2.next;
    }
}
