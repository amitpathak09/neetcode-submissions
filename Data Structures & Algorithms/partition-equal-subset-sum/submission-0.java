class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int i=0; i<nums.length; i++) {
            sum+=nums[i];
        }

        if(sum%2!=0) return false;

        int halfSum = sum/2;
        return dp(nums, 0, halfSum);
    }

    private boolean dp(int[] nums, int i, int target) {
        if(i>=nums.length) {
            return false;
        }
        if(target-nums[i]==0) return true;
        return dp(nums, i+1, target-nums[i])||dp(nums, i+1, target);
    }
}
