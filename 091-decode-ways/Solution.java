class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int[] dp = new int[chars.length];
        dp[0] = chars[0] != '0' ? 1 : 0;
        for (int i = 1; i < chars.length; ++i) {
            char curr = chars[i];
            char prev = chars[i - 1];
            if (curr != '0') {
                dp[i] = dp[i - 1];
            }
            if (prev == '1' || (prev == '2' && curr <= '6')) {
                dp[i] += i >= 2 ? dp[i - 2] : 1;
            }
        }
        return dp[chars.length - 1];
    }
}
