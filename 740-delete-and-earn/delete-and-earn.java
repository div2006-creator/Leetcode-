class Solution {
    int[]dp;
    public int deleteAndEarn(int[] nums) {   
     int[] sum = new int[10002];
for(int x:nums){
    sum[x]+=x;
}
dp = new int[10002];
Arrays.fill(dp,-1);
return fun(10000,sum);
    }

     public int fun(int i, int[] sum) {
        if (i < 0) {
            return 0;
        }

        if (dp[i] != -1) {
            return dp[i];
        }
        int c1 = sum[i] + fun(i - 2, sum);
        int c2 = fun(i - 1, sum);
        return dp[i] = Math.max(c1,c2);
    }
}