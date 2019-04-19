class Solution {
    public int maxProfit(int[] prices) {
        int maxDiff = 0;
        int l = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < prices[l]) {
                l = i;
            } else {
                maxDiff = Math.max(maxDiff, prices[i] - prices[l]);
            }
        }
        return maxDiff;
    }
}
