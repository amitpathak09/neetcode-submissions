class MedianFinder {
    int count = 0;
    PriorityQueue<Integer> small;
    PriorityQueue<Integer> large;

    public MedianFinder() {
        small=new PriorityQueue<>(Collections.reverseOrder());
        large=new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        count++;
        if(!large.isEmpty() && large.peek()<=num) {
            large.offer(num);
        } else {
            small.offer(num);
        }
        if(large.size()-small.size()>=2) {
            int temp = large.poll();
            small.offer(temp);
        } else if(small.size()-large.size()>=2) {
            int temp = small.poll();
            large.offer(temp);
        }
    }
    
    public double findMedian() {
        if((large.size()+small.size())%2==0) {
            return (double)(large.peek()+small.peek())/2;
        } else if (large.size()>small.size()) {
            return (double)large.peek();
        } else {
            return (double)small.peek();
        }
    }
}
