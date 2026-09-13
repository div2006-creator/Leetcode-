class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;

        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int c1 = sum / 2;

        boolean[] dp = new boolean[c1 + 1];
        dp[0] = true;
        for (int num : nums) {
            for (int i = c1; i >= num; i--) {
                dp[i] = dp[i] || dp[i - num];
            }
        }

        return dp[c1];
    }
}