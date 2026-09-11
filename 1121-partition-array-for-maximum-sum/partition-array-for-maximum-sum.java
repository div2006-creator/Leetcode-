class Solution {
    int dp[][] = new int[501][501];
    int fun(int[] arr, int k, int prev, int i, int max) {

        if(i == arr.length) return 0;

        if(dp[prev][i] != -1) return dp[prev][i];

        max = Math.max(max, arr[i]);

        int len = i - prev + 1;
        int ans = 0;

        if(len == k) {
            int partition = len * max + fun(arr, k, i + 1, i + 1, 0);
            ans = Math.max(ans, partition);
        } 
        else {
            int take = fun(arr, k, prev, i + 1, max);

            int np = len * max + fun(arr, k, i + 1, i + 1, 0);

            ans = Math.max(ans, take);
            ans = Math.max(ans, np);
        }

        return dp[prev][i] = ans;
    }

    public int maxSumAfterPartitioning(int[] arr, int k) {
        for(int i = 0; i < 501; i++)
            Arrays.fill(dp[i], -1);

        return fun(arr, k, 0, 0, 0);
    }
}