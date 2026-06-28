class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> threeSum(int[] nums) {
        res = new ArrayList<>();
        Arrays.sort(nums);
        //[-4,-1,-1,0,1,2]

        for(int i=0; i<nums.length-2; i++) {
            if(i==0 || i>0 && nums[i]!=nums[i-1]) {
                twoSum(nums, i+1, 0-nums[i]);
            }
        }
        return res;
    }

    private void twoSum(int[] nums, int i, int target) {
        int l=i;
        int r=nums.length-1;
        //[-1,-1,0,1]
        while(l<r) {
            int sum =nums[l]+nums[r];
            if(sum==target) {
                ArrayList<Integer> out = new ArrayList<>();
                out.add(0-target);
                out.add(nums[l]);
                out.add(nums[r]);
                res.add(List.copyOf(out));
                l+=1;
                r-=1;
                while(l<r && nums[l]==nums[l-1]) {
                    l++;
                }
                while(l<r && nums[r]==nums[r+1]) {
                    r--;
                }

            } else if(sum>target) {
                r--;
            } else {
                l++;
            }
            
            // if(l>=r) {
            //     break;
            // }
            // while(l<nums.length-1 && nums[l]==nums[l+1]) {
            //     l++;
            // }
            // while(r>1 && nums[r]==nums[r-1]) {
            //     r--;
            // }
        }
    }
}
