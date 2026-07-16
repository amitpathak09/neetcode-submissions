class Solution {
    public int trap(int[] height) {
        int[] ttr = new int[height.length];
        int[] ttl = new int[height.length];

        ttl[0] = height[0];
        for(int i=1; i<height.length; i++) {
            ttl[i]=Math.max(ttl[i-1],height[i]);
        }
        ttr[height.length-1] = height[height.length-1];
        for(int j=height.length-2; j>=0; j--) {
            ttr[j]=Math.max(ttr[j+1],height[j]);
        }

        int totalWater = 0;
        for(int i=1; i<height.length-1; i++) {
            totalWater+=Math.min(ttl[i],ttr[i])-height[i];
        }
        return totalWater;
    }
}
