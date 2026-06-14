class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> diff = new HashMap<>();
        int[] indices = new int[2];
        for(int i=0; i<nums.length; i++) {
            diff.put(nums[i], i);
        }

        for(int j=0; j<nums.length; j++) {
            if(diff.containsKey(target-nums[j]) && j!=diff.get(target-nums[j])) {
                indices[0] = j;
                indices[1] = diff.get(target-nums[j]);
                return indices;
            }
        }
        return indices;
    }
}
