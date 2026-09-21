class Solution {
    public int lengthOfLIS(int[] nums) {
        int ans = 0;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        for(int i = 0; i < nums.length; i++) {
            ans = Math.max(ans, fun(i, nums, dp));
        }
        return ans;
    }

    public int fun(int i, int[] nums, int[] dp) {
        if(i >= nums.length) {
            return 0;
        }
        if(dp[i] != -1) {
            return dp[i];
        }
        int m = 1;
        for(int j = i + 1; j < nums.length; j++) {

            if(nums[j] > nums[i]) {

                int c1 = 1 + fun(j, nums, dp);
                m = Math.max(m, c1);

            }
        }

        return dp[i] = m;
    }
}