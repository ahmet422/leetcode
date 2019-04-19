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
