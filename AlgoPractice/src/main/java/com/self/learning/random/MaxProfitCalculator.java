package com.self.learning.random;

public class MaxProfitCalculator {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        int[] stockPricesYesterday = new int[] {10, 7, 5, 8, 11, 9};
        //{10, 6, 18, 7, 5, 8, 11, 9}
        System.out.println(findMaxProfit(stockPricesYesterday));

    }

    private static int findMaxProfit(int[] stockPrices){
        int length = stockPrices.length;
        int maxProfit=0;
        for(int i=0;i< length-1;){
            while((i<length-1) && (stockPrices[i+1]<=stockPrices[i])){
                i++;
            }
            int buyPrice = stockPrices[i];
            while((i<length-1) && (stockPrices[i+1]>=stockPrices[i])){
                i++;
            }
            int sellPrice = stockPrices[i];
            int profit = sellPrice - buyPrice;
            if(profit >= maxProfit){
                maxProfit = profit;
            }
        }
        return maxProfit;
    }
}
