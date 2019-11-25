import java.util.Random;

public class Solution {
    private int[] nums;
    private Random random;

    public Solution(int[] nums) {
        this.nums = nums;
        random = new Random();
    }

    public int[] reset() {
        return nums;
    }

    public int[] shuffle() {
        int[] res = nums.clone();
        int len = nums.length;
        for (int start = 0; start < len; start++) {
            int randnum = randnum(start, len - 1);
            int tmp = res[randnum];
            res[randnum] = res[start];
            res[start] = tmp;

        }
        return res;
    }

    private int randnum(int min, int max) {
        return random.nextInt((max - min) + 1) + min;
    }
}
