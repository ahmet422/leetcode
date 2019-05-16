class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0;
        for (int l = 0, r = height.length - 1; l < r;) {
            int area = (r - l) * Integer.min(height[l], height[r]);
            if (area > maxArea) {
                maxArea = area;
            }
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return maxArea;
    }
}
