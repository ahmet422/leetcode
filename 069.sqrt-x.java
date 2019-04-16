/*-
 * [69] Sqrt(x)
 *
 * https://leetcode.com/problems/sqrtx/description/
 *
 * algorithms
 * Easy (30.98%)
 * Total Accepted:    347.5K
 * Total Submissions: 1.1M
 * Testcase Example:  '4'
 *
 * Implement int sqrt(int x).
 * 
 * Compute and return the square root of x, where x is guaranteed to be a
 * non-negative integer.
 * 
 * Since the return type is an integer, the decimal digits are truncated and
 * only the integer part of the result is returned.
 * 
 * Example 1:
 * 
 * 
 * Input: 4
 * Output: 2
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since 
 * the decimal part is truncated, 2 is returned.
 * 
 * 
 */
class Solution {
    public int mySqrt(int x) {
        if (x <= 0) {
            return 0;
        }
        return findSqrt(x, 1, x);
    }

    private int findSqrt(int x, int low, int high) {
        if (low > high) {
            return high;
        }
        int middle = (high + low) / 2;
        if (middle == x / middle) {
            return middle;
        } else if (middle > x / middle) {
            return findSqrt(x, low, middle - 1);
        } else {
            return findSqrt(x, middle + 1, high);
        }
    }
}

