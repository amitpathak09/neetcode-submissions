class Solution {
    public int maxProfit(int[] prices) {
        int days = prices.length;
        int minPrice=101;
        int maxProfit = 0;

        for(int i=0; i<days; i++) {
            if(prices[i]<minPrice) {
                minPrice=prices[i];
            } else if(prices[i]-minPrice>maxProfit){
                maxProfit=prices[i]-minPrice;
            }
        }
        return maxProfit;      
    }
}
