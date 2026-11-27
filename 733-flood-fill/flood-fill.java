 class Solution {
    public int[][] floodFill(int[][] ans, int sr, int sc, int c2) {
        int c1 = ans[sr][sc];
        if (c1 != c2) {
            dfs(ans, sr, sc, c1, c2);
        }
    return ans;
    }
    private void dfs(int[][] ans, int r, int c, int c1, int c2) {
        if (r < 0 || r >= ans.length || c < 0 || c >= ans[0].length || ans[r][c] != c1) {
            return;
        }

        ans[r][c] =c2;
        dfs(ans, r + 1, c, c1, c2);
        dfs(ans, r - 1, c, c1, c2);
        dfs(ans, r, c + 1, c1, c2);
        dfs(ans, r, c - 1, c1, c2);
    }
}
