class Solution {
    public int maxProduct(int[] nums) {
        int size = nums.length;

        int res = nums[0];
        int currMin = 1;
        int currMax = 1;

        for(int num: nums) {
            int temp = currMax*num;
            currMax = Math.max(Math.max(currMin*num, currMax*num),num);
            currMin = Math.min(Math.min(currMin*num, temp),num);
            res=Math.max(res, currMax);
        }
        return res;
        
    }
}
