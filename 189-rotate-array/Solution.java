class Solution {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        int[] temp = new int[k];
        for (int i = nums.length - k, j = 0; i < nums.length; ++i, ++j) {
            temp[j] = nums[i];
        }
        for (int i = nums.length - k - 1; i >= 0; --i) {
            nums[i + k] = nums[i];
        }
        for (int j = 0; j < k; ++j) {
            nums[j] = temp[j];
        }
    }
}
