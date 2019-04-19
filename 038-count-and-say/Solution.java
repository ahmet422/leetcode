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
