class Solution {
    public int rob(int[] nums) {
        int size = nums.length;
        if(size==1) return nums[0];

        int[] maxMoney = new int[size];
        maxMoney[0] = nums[0];
        maxMoney[1] = Math.max(nums[0], nums[1]);
        for(int i=2; i<size; i++) {
            maxMoney[i] = Math.max(nums[i]+maxMoney[i-2], maxMoney[i-1]);
        }
        return maxMoney[size-1];
    }
}
