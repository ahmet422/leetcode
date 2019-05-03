class Solution {
    public boolean isPowerOfThree(int n) {
        // maxPowerOfThree is 3^19=1162261467, 3^20 is bigger than int
        return (n > 0 && 1162261467 % n == 0);
    }
}
