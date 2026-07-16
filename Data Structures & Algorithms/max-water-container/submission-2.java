class Solution {
    public int maxArea(int[] heights) {
        int l=0;
        int r=heights.length-1;
        int maxAr=0;

        while(l<r) {
            int ar = area(l,r,heights);
            maxAr=ar>maxAr?ar:maxAr;
            if(heights[l]<heights[r]) {
                l++;
            } else {
                r--;
            }
        }
        return maxAr;
    }

    private int area(int l, int r, int[] heights) {
        return (r-l)*Math.min(heights[l],heights[r]);
    }


}
