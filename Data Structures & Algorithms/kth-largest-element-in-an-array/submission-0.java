class Solution {
    public int findKthLargest(int[] nums, int k) {
        int size = nums.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<size; i++) {
            pq.offer(nums[i]);
        }

        while(pq.size()>k) {
            pq.poll();
        }
        return pq.peek();
    }
}
