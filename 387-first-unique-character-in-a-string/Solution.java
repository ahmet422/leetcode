class Solution {
    public int firstUniqChar(String s) {
        if (s != null && !s.isEmpty()) {
            int result = s.length();
            for (char c = 'a'; c <= 'z'; c++) {
                int i = s.indexOf(c);
                if (i != -1 && i < result && i == s.lastIndexOf(c)) {
                    result = i;
                }
            }
            if (result < s.length()) {
                return result;
            }
        }
        return -1;
    }
}
