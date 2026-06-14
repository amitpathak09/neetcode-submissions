class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> required = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            if(required.containsKey(nums[i])) {
                return new int[]{required.get(nums[i]), i};
            } else {
                required.put(target-nums[i],i);
            }
        }
        return new int[2];
        
    }
}
