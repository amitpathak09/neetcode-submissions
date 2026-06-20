class KthLargest {

    PriorityQueue<Integer> minHeap;
    int k;

    public KthLargest(int k, int[] nums) {
        this.minHeap = new PriorityQueue<>();
        this.k=k;
        for(int num: nums) {
            this.minHeap.add(num);
        }
    }
    
    public int add(int val) {
        minHeap.add(val);
        //System.out.println(minHeap);
        while(minHeap.size()>k) {
            minHeap.poll();
        }
        //System.out.println(minHeap);
        return minHeap.peek();
    }
}
