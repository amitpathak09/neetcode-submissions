class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for(int num: nums) {
            if(!set.add(num)) {
                System.out.println(num);
                return true;
            }
        }
        return false;
        
    }
}