class Solution {
    public int removeElement(int[] nums, int val) {
        int n=nums.length;
        int l=0;
        int r=0;
        //Arrays.sort(nums);

        while(r<n && l<n) {
            //System.out.printf("L: %d, R: %d\n", l, r);
            if(nums[l]==val) {
                if(nums[r]!=val) {
                    nums[l]=nums[r];
                    nums[r]=val;
                    l++;
                    r++;
                } else {
                    r++;
                }
            } else {
                l++;
                r++;
            }
        }
        return l;
    }
}