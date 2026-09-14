class Solution {
    int[] dp;

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        dp = new int[n];
        Arrays.fill(dp, -1);
        int c1 = solve(nums, 0, n - 2);
        Arrays.fill(dp, -1);
        int c2 = solve(nums, 1, n - 1);
        return Math.max(c1, c2);
    }
    public int solve(int[] nums, int i, int end) {
        if (i > end) {
            return 0;
        }
       if (dp[i] != -1) {
            return dp[i];
        }
        int c1 = nums[i] + solve(nums, i + 2, end);
        int c2 = solve(nums, i + 1, end);
        return dp[i] = Math.max(c1, c2);
    }
}