class Node {
    String val;
    Node next;
    Node prev;
    int ind;

    Node(String val, int ind) {
        this.ind = ind;
        this.val = val;
        this.next = null;
        this.prev = null;
    }
}

class BrowserHistory {
    int i = 0;
    Node last = null;
    Node head = null;
    Node curr = null;

    public BrowserHistory(String homepage) {
        Node node = new Node(homepage, i);
        i++;
        curr = node;
        head = node;
        last = node;
    }

    public void visit(String url) {
        Node node = new Node(url, i);
        i++;
        curr.next = node;
        node.prev = curr;
        curr = node;
        last = node;
    }

    public String back(int steps) {
        while (steps > 0 && curr.prev != null) {
            curr = curr.prev;
            steps--;
        }
        return curr.val;
    }

    public String forward(int steps) {
        while (steps > 0 && curr.next != null) {
            curr = curr.next;
            steps--;
        }
        return curr.val;
    }
}
