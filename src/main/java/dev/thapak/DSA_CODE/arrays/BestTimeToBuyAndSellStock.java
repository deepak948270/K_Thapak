package dev.thapak.DSA_CODE.arrays;

public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        int [] prices =new int []{ 7,1,5,3,6,4};
        int maxProfit = maxProfit(prices);
        System.out.println(maxProfit);
    }
    public static int maxProfit(int[] prices) {

        int minPriceOfStockToBuy=prices[0]; // assume minimum price at which stock buys
        int profit =0;

        for(int i=0;i<prices.length;i++){

            // if current stock prices is lesser then price of already buy stock then buy the stock at lower price
            if(prices[i]<minPriceOfStockToBuy){
                minPriceOfStockToBuy=prices[i];
            }

            // check for the max profit we made
            profit =Math.max(profit,prices[i]-minPriceOfStockToBuy);
        }

        return profit;

    }
}
