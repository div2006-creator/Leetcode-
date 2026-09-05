// class Solution {
//     public int deleteAndEarn(int[] nums) {
//         int[] points = new int[1002];

//         for (int num : nums) {
//             points[num] += num;
//         }

//         int[] dp = new int[1002];
//         Arrays.fill(dp, -1);

//         return solve(0, points, dp);
//     }

//     int solve(int i, int[] points, int[] dp) {

//         if (i >= points.length) {
//             return 0;
//         }
//         if (dp[i] != -1) {
//             return dp[i];
//         }

//         int take = points[i] + solve(i + 2, points, dp);
//         int skip = solve(i + 1, points, dp);

//         return dp[i] = Math.max(take, skip);
//     }
// }




class Solution {

    public int deleteAndEarn(int[] nums) {

        Arrays.sort(nums);

        int n = nums.length;
        int[] dp = new int[n];

        Arrays.fill(dp, -1);

        return solve(0, nums, dp);
    }

    int solve(int i, int[] nums, int[] dp) {

        if (i >= nums.length) {
            return 0;
        }
        if (dp[i] != -1) {
            return dp[i];
        }

        int sum = 0;
        int j = i;

        while (j < nums.length && nums[j] == nums[i]) {
            sum += nums[j];
            j++;
        }

        int next = j;

        while (next < nums.length && nums[next] == nums[i] + 1) {
            next++;
        }

        int take = sum + solve(next, nums, dp);
        int skip = solve(j, nums, dp);

        return dp[i] = Math.max(take, skip);
    }
}