class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        
        return Math.max(fun(nums, 0, nums.length - 2), fun(nums, 1, nums.length - 1));
    }
    
    private int fun(int[] nums, int start, int end) {
        if (start > end) return 0;
        
        int length = end - start + 1;
        if (length == 1) return nums[start];
        
        int[] dp = new int[length];
        dp[0] = nums[start];
        dp[1] = Math.max(nums[start], nums[start + 1]);
        
        for (int i = 2; i < length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[start + i]);
        }
        
        return dp[length - 1];
    }
}
