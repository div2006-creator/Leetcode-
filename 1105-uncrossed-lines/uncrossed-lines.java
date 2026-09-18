class Solution {
    int[][] dp;
    public int maxUncrossedLines(int[] c1, int[] c2) {
        dp = new int[c1.length][c2.length];
        for (int i = 0; i < c1.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return fun(c1, c2, 0, 0);
    }
    public int fun(int[] c1, int[] c2, int i, int j) {
        if (i == c1.length || j == c2.length) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (c1[i] == c2[j]) {
            return dp[i][j] = 1 + fun(c1, c2, i + 1, j + 1);
        }
        return dp[i][j] = Math.max(
            fun(c1, c2, i + 1, j),
            fun(c1, c2, i, j + 1)
        );
    }
}