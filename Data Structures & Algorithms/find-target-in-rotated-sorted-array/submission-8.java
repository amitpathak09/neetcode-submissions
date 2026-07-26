class Solution {
    public int search(int[] nums, int target) {
        if(nums.length==1) {
            return nums[0]==target?0:-1;
        }
        int poI = poi(nums);
        //inside 2nd half
        if(target>=nums[poI] && target<=nums[nums.length-1]) {
            return binarySearch(nums, poI, nums.length-1, target);
        } else if(poI-1>=0){
            return binarySearch(nums,0, poI-1, target);
        }
        return -1;
    }

    private int poi(int[] nums) {
        int poI=0;
        for(int i=0; i<nums.length; i++) {
            if(i+1<nums.length && nums[i]>nums[i+1]) {
                poI = i+1;
                break;
            }
        }
        System.out.println("poi:"+poI);
        return poI;
    }

//1,2,3,4,5,7
    private int binarySearch(int[] nums, int i, int j, int target) {
        System.out.println(j);
        int start = i;
        int end = j;

        while(start<=end) {
            int mid =(start+end)/2;
            if(nums[mid]==target) {
                return mid;
            } else if(nums[mid]>target) {
                end=mid-1;
            } else {
                start=mid+1;
            }
        }
        return -1;

    }
}
