/*-
 * [38] Count and Say
 *
 * https://leetcode.com/problems/count-and-say/description/
 *
 * algorithms
 * Easy (39.97%)
 * Total Accepted:    270.1K
 * Total Submissions: 675.7K
 * Testcase Example:  '1'
 *
 * The count-and-say sequence is the sequence of integers with the first five
 * terms as following:
 * 
 * 
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 
 * 
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * 
 * Given an integer n where 1 ≤ n ≤ 30, generate the n^th term of the
 * count-and-say sequence.
 * 
 * Note: Each term of the sequence of integers will be represented as a
 * string.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: 1
 * Output: "1"
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: 4
 * Output: "1211"
 * 
 */
class Solution {
    public String countAndSay(int n) {
        String str = "1";
        for (int i = 0; i < n - 1; i++) {
            StringBuilder strBuild = new StringBuilder();
            char lastChar = str.charAt(0);
            int count = 1;
            for (int j = 1; j < str.length(); j++) {
                if (str.charAt(j) != lastChar) {
                    strBuild.append(Integer.toString(count)).append(lastChar);
                    lastChar = str.charAt(j);
                    count = 1;
                } else {
                    count++;
                }
            }
            strBuild.append(Integer.toString(count)).append(lastChar);
            str = strBuild.toString();
        }
        return str;
    }
}
