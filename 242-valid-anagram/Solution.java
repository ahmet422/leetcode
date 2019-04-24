class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] letterCounts = new int['z' - 'a' + 1];
        for (int i = 0; i < s.length(); ++i) {
            letterCounts[s.charAt(i) - 'a']++;
            letterCounts[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < letterCounts.length; ++i) {
            if (letterCounts[i] < 0) {
                return false;
            }
        }
        return true;
    }
}
