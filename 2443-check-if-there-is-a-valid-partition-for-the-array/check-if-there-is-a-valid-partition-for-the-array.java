class Solution {

    Boolean[] dp;

    public boolean validPartition(int[] nums) {
        dp = new Boolean[nums.length];
        return solve(nums, 0);
    }

    public boolean solve(int[] nums, int i) {

        if (i == nums.length) {
            return true;
        }

        if (dp[i] != null) {
            return dp[i];
        }

        if (i + 1 < nums.length &&
            nums[i] == nums[i + 1] &&
            solve(nums, i + 2)) {

            return dp[i] = true;
        }

        if (i + 2 < nums.length) {

            if (nums[i] == nums[i + 1] &&
                nums[i + 1] == nums[i + 2] &&
                solve(nums, i + 3)) {

                return dp[i] = true;
            }

            if (nums[i] + 1 == nums[i + 1] &&
                nums[i + 1] + 1 == nums[i + 2] &&
                solve(nums, i + 3)) {

                return dp[i] = true;
            }
        }

        return dp[i] = false;
    }
}



