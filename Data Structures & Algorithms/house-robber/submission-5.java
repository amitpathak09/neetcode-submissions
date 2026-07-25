class Solution {
    int[] res;
    public int rob(int[] nums) {
        res = new int[nums.length];
        Arrays.fill(res,-1);
        return dp(nums,0);
    }

    private int dp(int[] nums, int i) {
        if(i>=nums.length) return 0;
        if(res[i]!=-1) return res[i];
        res[i] = Math.max(nums[i]+dp(nums, i+2), dp(nums,i+1));
        return res[i];
    }
}
