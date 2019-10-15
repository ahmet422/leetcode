class Solution {
    public int rob(int[] nums) {
        int rob = 0;
        int notRob = 0;
        for (int n : nums) {
            int currRob = n + notRob;
            notRob = Math.max(rob, notRob);
            rob = currRob;
        }
        return Math.max(rob, notRob);
    }
}
