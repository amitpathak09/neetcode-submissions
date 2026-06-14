class Solution {
    public int minCostClimbingStairs(int[] cost) {
        
        int n = cost.length;
        int totalCost[] = new int[n+1];
        totalCost[0]=0;
        totalCost[1]=0;
        // totalCost[2]=Math.min(cost[0], cost[1]);
        // if(n==2) return total[2];
        for(int i=2; i<=n; i++) {
            totalCost[i] = Math.min(totalCost[i-2]+cost[i-2], totalCost[i-1]+cost[i-1]);
            System.out.println(totalCost[i]+" i:"+i);
        }
        return totalCost[n];
    }
}
