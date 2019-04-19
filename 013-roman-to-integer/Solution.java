class Solution {
    public int romanToInt(String s) {
        int result = 0;
        char prev = ' ';
        for (char c : s.toCharArray()) {
            switch (c) {
                case 'M':
                    result += prev == 'C' ? 800 : 1000;
                    break;
                case 'D':
                    result += prev == 'C' ? 300 : 500;
                    break;
                case 'C':
                    result += prev == 'X' ? 80 : 100;
                    break;
                case 'L':
                    result += prev == 'X' ? 30 : 50;
                    break;
                case 'X':
                    result += prev == 'I' ? 8 : 10;
                    break;
                case 'V':
                    result += prev == 'I' ? 3 : 5;
                    break;
                case 'I':
                    result += 1;
            }
            prev = c;
        }
        return result;
    }
}
