class Solution {
    public int majorityElement(int[] nums) {
        int major = nums[0], countDiff = 1;
        for (int i = 1; i < nums.length; ++i) {
            if (countDiff == 0) {
                major = nums[i];
                countDiff++;
            } else if (major == nums[i]) {
                countDiff++;
            } else {
                countDiff--;
            }
        }
        return major;
    }
}
