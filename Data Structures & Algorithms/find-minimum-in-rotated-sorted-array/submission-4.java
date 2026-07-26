class Solution {
    public int findMin(int[] nums) {
        if(nums.length==1) {
            return nums[0];
        }

        int pointOfInflection = 0;

        for(int i=0; i<nums.length; i++) {
            if(i+1<nums.length && nums[i]>nums[i+1]) {
                pointOfInflection=i+1;
            }
            // } else if(nums[i-1]>nums[i]&&nums[i+1]>nums[i]) {
            //     pointOfInflection = i;
            //     break;
            // }
        }

        return nums[pointOfInflection];


    }
}
