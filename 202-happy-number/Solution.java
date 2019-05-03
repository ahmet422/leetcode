class Solution {
    public boolean isHappy(int n) {
        if (n < 10) {
            return (n == 1 || n == 7);
        }
        int sum = 0;
        for (; n > 0; n /= 10) {
            int b = n % 10;
            sum += b * b;
        }
        return isHappy(sum);
    }
}
