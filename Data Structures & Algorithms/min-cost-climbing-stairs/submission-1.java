class Solution {
    public int minCostClimbingStairs(int[] cost) {
        //to reach at nth staircase -> min(n-1, n-2)
        int n = cost.length;

        int[] mincost = new int[n+1];
        mincost[0]=0;
        mincost[1]=0;

        for(int i=2; i<n+1; i++) {
            mincost[i] = Math.min(mincost[i-2]+cost[i-2],mincost[i-1]+cost[i-1]);
        }
        return mincost[n];
    }
}
