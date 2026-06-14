class Solution {

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int n : nums) sum += n;

        if (sum % 2 != 0) return false;

        int target = sum / 2;

        Boolean[][] memo = new Boolean[nums.length][target + 1];
        return dp(nums, 0, target, memo);
    }

    private boolean dp(int[] nums, int i, int target, Boolean[][] memo) {

        if (target == 0) return true;
        if (i >= nums.length || target < 0) return false;

        if (memo[i][target] != null) {
            return memo[i][target];
        }

        boolean result = dp(nums, i + 1, target - nums[i], memo)
                      || dp(nums, i + 1, target, memo);

        memo[i][target] = result;
        return result;
    }
}
