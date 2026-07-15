class Solution {
    public int findDuplicate(int[] nums) {
        //1,2,3,4,4
        //-1,2,3,4,4
        //-1,-2,3,4,4
        //-1,-2,-3,4,4

        for(int num: nums) {
            if(nums[Math.abs(num)-1]<0) return Math.abs(num);
            else {
                nums[Math.abs(num)-1]*=-1;
            }
        }
        return 0;
    }
}
