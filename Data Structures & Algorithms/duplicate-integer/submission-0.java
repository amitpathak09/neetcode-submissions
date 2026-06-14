class Solution {
    public boolean hasDuplicate(int[] nums) {
        ArrayList<Integer> occurances = new ArrayList<>();
        for(int i=0; i<nums.length; i++) {
            if(occurances.contains(nums[i])) {
                return true;
            } 
            occurances.add(nums[i]);
        }
        return false;
    }
}