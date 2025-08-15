class MyQueue {
    Stack<Integer> st ;
    public MyQueue() {
        st = new Stack<>();
    }
    
    public void push(int x) {
        st.push(x);
    }
    
    public int pop() {
        return helper();
    }
    
    public int peek() {
        int x = st.pop();
        if(st.isEmpty()){
            st.push(x);
            return x;}
        int check = peek();
        st.push(x);
        return check;
    }
    
    
    public boolean empty() {
        return st.isEmpty();
    }
    public int helper(){
        int x = st.pop();
        if(st.isEmpty()) return x;
        int check = helper();
        st.push(x);
        return check;
    }
    
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */