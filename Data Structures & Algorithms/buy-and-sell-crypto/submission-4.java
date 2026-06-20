class Solution {
    public int maxProfit(int[] prices) {
        int days = prices.length;
        //int[] minToLeft = new int[days];
        //minToLeft[0] = 1000;
        
        int[] maxToRight = new int[days];
        maxToRight[days-1] = -1;
        int maxProfit = 0;

        for(int i=1; i<days; i++) {
            //minToLeft[i]=prices[i-1]<minToLeft[i-1]?prices[i-1]:minToLeft[i-1];
            maxToRight[days-1-i]=prices[days-1-i+1]>maxToRight[days-1-i+1]?prices[days-1-i+1]:maxToRight[days-1-i+1];
        }

        for(int i=0; i<days-1; i++) {
            if(maxToRight[i]-prices[i]>maxProfit) {
                maxProfit=maxToRight[i]-prices[i];
            }
        }
        return maxProfit;      
    }
}
