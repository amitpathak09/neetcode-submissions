class Solution {

    List<List<Integer>> res;
    HashSet<List<Integer>> unique;
    public List<List<Integer>> threeSum(int[] nums) {
        res = new ArrayList<>();
        unique = new HashSet<>();
        for(int i=0; i<nums.length; i++) {
            twoSum(nums, i+1, 0-nums[i]);
        }
        return res;
    }

    private void twoSum(int[] nums, int i, int target) {
        Set<Integer> hashset = new HashSet<>();
        for(int j=i; j<nums.length; j++) {
            if(hashset.contains(target-nums[j])) {
                List<Integer> out = new ArrayList<>();
                out.add(nums[j]);
                out.add(target-nums[j]);
                out.add(nums[i-1]);
                Collections.sort(out);
                if(!unique.contains(out)) {
                    res.add(List.copyOf(out));
                    unique.add(List.copyOf(out));
                }
            } else {
                hashset.add(nums[j]);
            }
        } 
    }
}
