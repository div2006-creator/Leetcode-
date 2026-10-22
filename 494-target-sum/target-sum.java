class Solution {
public int findTargetSumWays(int[] nums, int target) {
return fun(nums, 0, 0, target);
}

public int fun(int[] nums, int i, int sum, int target) {
    if (i == nums.length) {
        return sum == target ? 1 : 0;
    }

    int c1 = fun(nums, i + 1, sum + nums[i], target);
    int c2 = fun(nums, i + 1, sum - nums[i], target);

    return c1 + c2;
}


}
