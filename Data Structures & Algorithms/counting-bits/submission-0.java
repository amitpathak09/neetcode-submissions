class Solution {
    public int[] countBits(int n) {
        int[] counts = new int[n+1];

        for(int i=0;i<32; i++) {
            for(int j=0; j<=n; j++) {
                if((1<<i & j) !=0) {
                    counts[j]++;
                }
            }
        }
        return counts;
    }
}
