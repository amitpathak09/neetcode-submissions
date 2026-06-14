class Solution {
    public int rob(int[] nums) {
        int size = nums.length;
        if(size==0) return 0;
        if(size==1) return nums[0];
        int[] maxMoney = new int[size];

        //if we don't rob the last house
        maxMoney[0]=nums[0];
        maxMoney[1] = Math.max(nums[0], nums[1]);
        for(int i=2; i<size-1; i++) {
            maxMoney[i] = Math.max(maxMoney[i-1], nums[i]+maxMoney[i-2]);
        }
        int m1 = maxMoney[size-2];

        //if we don't rob the first house
        maxMoney[0] = 0;
        maxMoney[1] = nums[1];
        for(int i=2; i<size; i++) {
            maxMoney[i] = Math.max(maxMoney[i-1], nums[i]+maxMoney[i-2]);
        }

        int m2 = maxMoney[size-1];
        return Math.max(m1,m2);
    }
}
