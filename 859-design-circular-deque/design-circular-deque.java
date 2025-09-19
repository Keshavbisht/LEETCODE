class Node {
    int val;
    Node next;
    Node(int value) {
        this.val = value;
        this.next = null;
    }
}

class MyCircularDeque {
    int size;
    Node front;
    Node last;
    int curr;

    public MyCircularDeque(int k) {
        size = k;
        front = null;
        last = null;
        curr = 0;
    }
    
    public boolean insertFront(int value) {
        if (isFull()) return false;
        Node node = new Node(value);
        if (front == null && last == null) {
            front = node;
            last = node;
            last.next = front;
            curr++;
            return true;
        } else {
            node.next = front;
            front = node;
            last.next = front;
            curr++;
            return true;
        }
    }
    
    public boolean insertLast(int value) {
        if (isFull()) return false;
        Node node = new Node(value);
        if (front == null && last == null) {
            front = node;
            last = node;
            last.next = front;
            curr++;
            return true;
        } else {
            last.next = node;
            last = node;
            last.next = front;
            curr++;
            return true;
        }
    }
    
    public boolean deleteFront() {
        if (isEmpty()) return false;
        if (curr == 1) {
            front = null;
            last = null;
        } else {
            front = front.next;
            last.next = front;
        }
        curr--;
        return true;
    }
    
    public boolean deleteLast() {
        if (isEmpty()) return false;
        if (curr == 1) {
            front = null;
            last = null;
        } else {
            Node temp = front;
            while (temp.next != last) {
                temp = temp.next;
            }
            last = temp;
            last.next = front;
        }
        curr--;
        return true;
    }
    
    public int getFront() {
        return isEmpty() ? -1 : front.val;
    }
    
    public int getRear() {
        return isEmpty() ? -1 : last.val;
    }
    
    public boolean isEmpty() {
        return curr == 0;
    }
    
    public boolean isFull() {
        return curr == size;
    }
}
