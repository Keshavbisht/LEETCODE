class Node{
    char data;
    Node prev;
    Node next;
    Node(char data){
        this.data = data;
    }
}

class TextEditor {

    Node dummy;
    Node cursor;

    public TextEditor() {
        dummy = new Node('#');
        cursor = dummy;
    }

    public void addText(String text) {
        for(int i = 0; i < text.length(); i++){
            Node newNode = new Node(text.charAt(i));
            newNode.prev = cursor;
            newNode.next = cursor.next;
            if(cursor.next != null){
                cursor.next.prev = newNode;
            }
            cursor.next = newNode;
            cursor = newNode;
        }
    }

    public int deleteText(int k) {
        int deleted = 0;
        while(k > 0 && cursor != dummy){
            Node toDelete = cursor;
            cursor = cursor.prev;
            cursor.next = toDelete.next;
            if(toDelete.next != null){
                toDelete.next.prev = cursor;
            }
            deleted++;
            k--;
        }
        return deleted;
    }

    public String cursorLeft(int k) {
        while(k > 0 && cursor != dummy){
            cursor = cursor.prev;
            k--;
        }
        return printLeft();
    }

    public String cursorRight(int k) {
        while(k > 0 && cursor.next != null){
            cursor = cursor.next;
            k--;
        }
        return printLeft();
    }

    public String printLeft(){
        Node temp = cursor;
        StringBuilder sb = new StringBuilder();

        int count = 10;
        while(temp != dummy && count > 0){
            sb.append(temp.data);
            temp = temp.prev;
            count--;
        }
        return sb.reverse().toString();
    }
}
