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
