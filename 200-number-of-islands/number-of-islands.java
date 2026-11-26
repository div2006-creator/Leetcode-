class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int r = grid.length;
        int c = grid[0].length;
        int i = 0;
        for (int k = 0; k < r; k++) {
            for (int p = 0; p < c; p++) {
                if (grid[k][p] == '1') {
                    i++;
                    dfs(grid, k, p);
                }
            }
        }
        return i;
    }
    public void dfs(char[][] grid, int k, int p) {
        int r = grid.length;
        int c = grid[0].length;

        if (k < 0 || k >= r || p < 0 || p >= c || grid[k][p] == '0') {
            return;
        }
        grid[k][p] = '0';
        dfs(grid, k + 1, p); 
        dfs(grid, k - 1, p); 
        dfs(grid, k, p + 1); 
        dfs(grid, k, p - 1); 
    }
}
