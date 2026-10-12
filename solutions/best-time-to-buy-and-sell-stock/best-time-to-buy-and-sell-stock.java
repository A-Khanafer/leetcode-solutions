class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = prices[0];
        int profit= 0, max=0;
        for(int i = 0; i < prices.length; i++){
            if(prices[i] < minPrice){
                minPrice = prices[i];
                continue;
            }
            profit = prices[i] - minPrice;
            if(profit > max) max = profit;

        }

        return max;
    }
}

/*


[7, 1,  5,  3,  6,  4]









*/