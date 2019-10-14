class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return ret;
        }
        ret.add(new ArrayList<>());
        for (int n : nums) {
            for (int i = ret.size() - 1; i >= 0; --i) {
                List<Integer> clone = new ArrayList<>(ret.get(i));
                clone.add(n);
                ret.add(clone);
            }
        }
        return ret;
    }
}
