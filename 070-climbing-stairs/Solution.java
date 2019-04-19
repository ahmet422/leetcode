class Solution {
    public int climbStairs(int n) {
        // Binet's Formula for the nth Fibonacci number
        return (int) ((Math.pow((1 + Math.sqrt(5)) / 2, n + 1)
                - Math.pow((1 - Math.sqrt(5)) / 2, n + 1)) / Math.sqrt(5));
    }
}
