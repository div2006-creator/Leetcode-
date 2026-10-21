class Solution {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;

        int i = 0, j = 0, k = 0;

        for (int x = 1; x < n; x++) {
            int c1 = dp[i] * 2;
            int c2 = dp[j] * 3;
            int c3 = dp[k] * 5;

            int num = Math.min(c1, Math.min(c2, c3));
            dp[x] = num;

            if (num == c1) i++;
            if (num == c2) j++;
            if (num == c3) k++;
        }

        return dp[n - 1];
    }
}