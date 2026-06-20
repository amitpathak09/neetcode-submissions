class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] pToLeft = new int[nums.length];
        pToLeft[0] = 1;//nums[0];
        
        int[] pToRight = new int[nums.length];
        pToRight[nums.length-1]=1;//nums[nums.length-1];

        for(int i=1; i<nums.length; i++) {
            pToLeft[i]=pToLeft[i-1]*nums[i-1];
            pToRight[nums.length-1-i]=pToRight[nums.length-1-i+1]*nums[nums.length-1-i+1];
        }

        int[] products = new int[nums.length];
        for(int i=0; i<nums.length; i++) {
            products[i] = pToLeft[i]*pToRight[i];
        }
        return products;
        
    }
}  
