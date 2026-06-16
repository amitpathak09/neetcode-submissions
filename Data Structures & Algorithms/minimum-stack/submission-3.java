class MinStack {
    Deque<Integer> stack;
    Integer minVal = Integer.MAX_VALUE;
    PriorityQueue<Integer> minHeap;

    public MinStack() {
        stack = new ArrayDeque<>();
        minHeap = new PriorityQueue<>();
    }
    
    public void push(int val) {
        stack.push(val);
        if(minHeap.size()==0 || val<=minHeap.peek()) {
            minHeap.add(val);
        }
    }
    
    public void pop() {
        if(stack.size()==0) return;
        int temp = stack.pop();
        if(minHeap.peek()==temp) {
            minHeap.poll();
        }
    }
    
    public int top() {
        if(stack.size()==0) return Integer.MIN_VALUE;
        return stack.peek();
    }
    
    public int getMin() {
        if(minHeap.size()==0) return Integer.MAX_VALUE;
        return minHeap.peek();
    }
}
