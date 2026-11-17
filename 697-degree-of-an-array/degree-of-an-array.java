//                                      BRUTE FORCE
// class Solution {
//     public int findShortestSubArray(int[] nums) {
//         int n = nums.length;
//         int max = 0;
//         HashMap<Integer, Integer> map = new HashMap<>();
//         for (int x : nums) {
//             map.put(x, map.getOrDefault(x, 0) + 1);
//             max = Math.max(max, map.get(x));
//         }
//         int ans = n;
//         for (int i = 0; i < n; i++) {
//             HashMap<Integer, Integer> mp = new HashMap<>();
//             for (int j = i; j < n; j++) {
//                 mp.put(nums[j], mp.getOrDefault(nums[j], 0) + 1);

//                 if (mp.get(nums[j]) == max) {
//                     ans = Math.min(ans, j - i + 1);
//                 }
//             }
//         }
//         return ans;
//     }
// }





//                                            HashMap
class Solution {
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer, int[]> map = new HashMap<>();
        int max = 0;
        int ans = nums.length;
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            if (!map.containsKey(x)) {
                map.put(x, new int[]{1, i, 1});
            } else {
                int[] a = map.get(x);
                a[0]++;
                a[2] = i - a[1] + 1;
            }
            int[] a = map.get(x);
            if (a[0] > max) {
                max = a[0];
                ans = a[2];
            } else if (a[0] == max) {
                ans = Math.min(ans, a[2]);
            }
        }
        return ans;
    }
}



//                                     HashMap (Frequency + First + Last)

// class Solution {
//     public int findShortestSubArray(int[] nums) {
//         HashMap<Integer, Integer> freq = new HashMap<>();
//         HashMap<Integer, Integer> first = new HashMap<>();
//         HashMap<Integer, Integer> last = new HashMap<>();
//         int max = 0;
//         for (int i = 0; i < nums.length; i++) {
//             int x = nums[i];
//             freq.put(x, freq.getOrDefault(x, 0) + 1);
//             if (!first.containsKey(x)) {
//                 first.put(x, i);
//             }
//             last.put(x, i);
//             max = Math.max(max, freq.get(x));
//         }
//         int ans = nums.length;
//         for (int x : freq.keySet()) {
//             if (freq.get(x) == max) {
//                 int len = last.get(x) - first.get(x) + 1;
//                 ans = Math.min(ans, len);
//             }
//         }
//         return ans;
//     }
// }