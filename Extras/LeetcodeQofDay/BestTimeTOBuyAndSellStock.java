// pehle sbse sasta kis din par milra tha with current price uska profit nikallo 
class Solution {
    public int maxProfit(int[] prices) {
    int min = Integer.MAX_VALUE;
    int maxProfit = 0;
    for(int price : prices){
        min = Math.min(price , min);
        maxProfit = Math.max(price - min, maxProfit);
    }
    return maxProfit;
    }
}
