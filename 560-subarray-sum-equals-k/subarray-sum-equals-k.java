class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int s = 0;
        int count = 0;


            for (int num : nums) {
            s+= num;

            if (map.containsKey(s - k)) {
                count += map.get(s - k);
            }
         map.put(s, map.getOrDefault(s, 0) + 1);
        }
  
    return count;
    }
}

