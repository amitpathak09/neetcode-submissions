class Solution {
    public int lengthOfLIS(int[] nums) {

        //[9,1,4,2,3,3,7]
        //[4,10,4,3,8,9]
        //+1,
        //0
        int[] lis = new int[nums.length];
        Arrays.fill(lis,1);

        for(int i=nums.length-2; i>=0; i--) {

            for(int j=i+1; j<nums.length; j++) {
                if(nums[i]<nums[j]&& lis[j]+1>lis[i]) {
                    lis[i] = 1+lis[j];
                }
            }
        }
        int maxLis = 1;
        for(int i=0; i<nums.length; i++) {
            if(maxLis<lis[i]) {
                maxLis = lis[i];
            }
        }
        return maxLis;
    }
}
