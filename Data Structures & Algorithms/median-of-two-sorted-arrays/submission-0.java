class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        //TODO: account for one or more zero in m and n

        int i = m/2;
        while(i<=m && i>=0) {
            int maxLeftX = i<=0? Integer.MIN_VALUE:nums1[i-1];
            int minRightX = i>=m? Integer.MAX_VALUE:nums1[i];

            int j = (m+n)/2-i;
            int maxLeftY = j<=0?Integer.MIN_VALUE:nums2[j-1];
            int minRightY = j>=n?Integer.MAX_VALUE:nums2[j];

            if(maxLeftX<=minRightY && maxLeftY <=minRightX) {
                if((m+n)%2!=0) {
                    return Math.min(minRightX, minRightY);
                } else {
                    return (double)(Math.max(maxLeftX, maxLeftY)+Math.min(minRightX,minRightY))/2;
                }
            } else if(maxLeftX>minRightY) {
                i--;
            } else if(maxLeftY>minRightX) {
                i++;
            }
        }
        return 0;
    }
}
