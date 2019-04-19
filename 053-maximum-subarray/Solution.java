class Solution {
    public int maxSubArray(int[] nums) {
        int maxSubArray = Integer.MIN_VALUE;
        for (int i = 0, total = 0; i < nums.length; i++) {
            total += nums[i];
            if (maxSubArray < total) {
                maxSubArray = total;
            }
            if (total < 0) {
                total = 0;
            }
        }
        return maxSubArray;
    }
}
