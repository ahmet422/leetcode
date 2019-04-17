/*-
 * [125] Valid Palindrome
 *
 * https://leetcode.com/problems/valid-palindrome/description/
 *
 * algorithms
 * Easy (30.62%)
 * Total Accepted:    337.2K
 * Total Submissions: 1.1M
 * Testcase Example:  '"A man, a plan, a canal: Panama"'
 *
 * Given a string, determine if it is a palindrome, considering only
 * alphanumeric characters and ignoring cases.
 * 
 * Note: For the purpose of this problem, we define empty string as valid
 * palindrome.
 * 
 * Example 1:
 * 
 * 
 * Input: "A man, a plan, a canal: Panama"
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "race a car"
 * Output: false
 * 
 * 
 */
class Solution {
    public boolean isPalindrome(String s) {
        for (int l = 0, r = s.length() - 1; l <= r;) {
            if (Character.isLetterOrDigit(s.charAt(l))) {
                if (Character.isLetterOrDigit(s.charAt(r))) {
                    if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) {
                        return false;
                    }
                    l++;
                }
                r--;
            } else {
                l++;
            }
        }
        return true;
    }
}
