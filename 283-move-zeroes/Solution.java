class Solution {
    public void moveZeroes(int[] nums) {
        int nonZeroI = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != 0) {
                nums[nonZeroI++] = nums[i];
            }
        }
        for (int i = nonZeroI; i < nums.length; ++i) {
            nums[i] = 0;
        }
    }
}
