class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        //Decreasing order queue
        Deque<Integer> monotonicQueue = new ArrayDeque<>();
        int n = nums.length;
        int[] res = new int[n-k+1];

        for(int i=0; i<n; i++) {
            while(!monotonicQueue.isEmpty() && monotonicQueue.peekFirst()<i-k+1) {
                monotonicQueue.pollFirst();
            }

            while(!monotonicQueue.isEmpty() && nums[i]>nums[monotonicQueue.peekLast()]) {
                monotonicQueue.pollLast();
            }

            monotonicQueue.offerLast(i);

            if(i>=k-1) {
                res[i-k+1] = nums[monotonicQueue.peekFirst()];
            }
        }

        return res;
        
    }
}