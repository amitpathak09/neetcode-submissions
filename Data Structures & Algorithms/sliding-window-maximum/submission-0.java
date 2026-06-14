class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0; i<k; i++) {
            pq.offer(nums[i]);
        }
        int n = nums.length;
        int[] res = new int[n-k+1];

        int l=0;
        int r=k-1;

        while(r<n) {
            int maxElement = pq.peek();
            res[l]=maxElement;
            pq.remove(nums[l]);
            l++;
            r++;
            if(r<n) {
                pq.offer(nums[r]);
            }
        }

        return res;
        
    }
}
