class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        return binSearch(0, n-1, nums, target);
    }

    int binSearch(int start, int end, int[] nums,int target) {

        if(nums[end]<target || nums[start]>target) return -1;
        int mid = (start+end)/2;

        if(target==nums[mid]) return mid;
        if(target==nums[start]) return start;
        if(target==nums[end]) return end;
        if(end-start==1) return -1;
        if(nums[mid]>target) {
            return binSearch(start, mid, nums, target);
        } else if(nums[mid]<target) {
            return binSearch(mid, end, nums, target);
        }
        return -1;
    }
}
