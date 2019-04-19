import java.util.HashMap;
import java.util.Map;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int length = 0, left = 0, right = 0;
        Map<Character, Integer> visited = new HashMap<>();
        while (right < s.length()) {
            if (visited.containsKey(s.charAt(right))) {
                left = Math.max(left, visited.get(s.charAt(right)));
            }
            visited.put(s.charAt(right), ++right);
            length = Math.max(length, right - left);
        }
        return length;
    }
}
