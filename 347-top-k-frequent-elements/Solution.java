class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            frequencyMap.put(nums[i], frequencyMap.getOrDefault(nums[i], 0) + 1);
        }
        List<Integer>[] bucket = new List[nums.length + 1];
        for (int num : frequencyMap.keySet()) {
            int frequency = frequencyMap.get(num);
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<Integer>();
            }
            bucket[frequency].add(num);
        }
        List<Integer> result = new ArrayList<Integer>(k);
        for (int i = bucket.length - 1; i >= 0 && result.size() <= k; i--) {
            if (bucket[i] != null) {
                result.addAll(bucket[i]);
            }
        }
        return result.subList(0, k);
    }
}
