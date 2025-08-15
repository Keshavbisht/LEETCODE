class MinStack {
    Stack<Integer> st;
    Stack<Integer> minst;
    int mi;

    public MinStack() {
        st = new Stack<>();
        minst = new Stack<>();
    }
    
    public void push(int val) {
        st.push(val);
        if(minst.isEmpty() || minst.peek() > val){
            minst.push(val);
        }
        else{
            
            minst.push(minst.peek());
        }
    }
    
    public void pop() {
        st.pop();
        minst.pop();
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
       return minst.peek();
    }
    // public void helper(){
    //     if(st.isEmpty()) return;
    //     int x = st.pop();
    //     mi = Math.min(mi, x);
    //     helper();
    //     st.push(x);
    // }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */