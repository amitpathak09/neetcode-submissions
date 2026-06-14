class Solution {
    public int maxProfit(int[] prices) {
        int smallest=prices[0];
        int profit = 0;
        int length = prices.length;

        for(int i=1; i<length; i++) {
            while(i<length && prices[i]<smallest) {
                smallest=prices[i];
                i++;
            }
            while(i<length &&(prices[i]-smallest)>profit) {
                profit = prices[i]-smallest;
                i++;
            }
            if(i<length && prices[i]<smallest) smallest=prices[i];
        }
        return profit;
        
    }
}
