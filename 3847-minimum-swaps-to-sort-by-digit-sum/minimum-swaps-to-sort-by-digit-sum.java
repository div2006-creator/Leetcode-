class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = sum(nums[i]);
        }
        Arrays.sort(arr, (a, b) -> {
            if (a[1] != b[1]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(arr[i][0], i);
        }
        boolean[] vis = new boolean[n];
        int swaps = 0;
        for (int i = 0; i < n; i++) {
            if (vis[i] || map.get(nums[i]) == i) {
                continue;
            }
            int j = i;
            int cycle = 0;
            while (!vis[j]) {
                vis[j] = true;
                j = map.get(nums[j]);
                cycle++;
            }
            swaps += cycle - 1;
        }
        return swaps;
    }
   public int sum(int num) {
        int s = 0;
        while (num > 0) {
            s += num % 10;
            num /= 10;
        }

       return s;
    }
}