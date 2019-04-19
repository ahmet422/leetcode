class Solution {
    public int removeDuplicates(int[] nums) {
        int l = nums.length;
        if (l < 2) {
            return l;
        }
        int count = 0;
        for (int j = 1; j < l; j++) {
            if (nums[j] != nums[count]) {
                nums[++count] = nums[j];
            }
        }
        return count + 1;
    }
}
