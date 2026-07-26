class Solution {
    
    
    public int rob(int[] nums) {
        if(nums.length==1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        int[] dp2 = new int[nums.length];
        Arrays.fill(dp, -1);
        Arrays.fill(dp2, -1);
        return Math.max(calc(nums, 0, nums.length-1, dp), calc(nums, 1, nums.length, dp2));
    }

    private int calc(int[] nums, int i, int j, int[] dp) {
        if(i>=j) {
            return 0;
        }
        if(dp[i]!=-1) {
            return dp[i];
        }
        dp[i] = Math.max(nums[i]+calc(nums, i+2, j, dp), calc(nums, i+1, j, dp));
        return dp[i];
    }
}
