class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;
        int curr = 0;
        int time = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    fresh++;
                }
                if (grid[i][j] == 2) {
                    q.offer(new int[]{i, j});
                }
            }
        }
        while (!q.isEmpty() && fresh > 0) {
            curr = q.size();
            while (curr-- > 0) {
                int[] p = q.poll();
                int x = p[0];
                int y = p[1];
                if (y - 1 >= 0 && grid[x][y - 1] == 1) {
                    fresh--;
                    grid[x][y - 1] = 2;
                    q.offer(new int[]{x, y - 1});
                }
                if (y + 1 < n && grid[x][y + 1] == 1) {
                    fresh--;
                    grid[x][y + 1] = 2;
                    q.offer(new int[]{x, y + 1});
                }
                if (x - 1 >= 0 && grid[x - 1][y] == 1) {
                    fresh--;
                    grid[x - 1][y] = 2;
                    q.offer(new int[]{x - 1, y});
                }
                if (x + 1 < m && grid[x + 1][y] == 1) {
                    fresh--;
                    grid[x + 1][y] = 2;
                    q.offer(new int[]{x + 1, y});
                }
            }
            time++;
        }
        return fresh == 0 ? time : -1;
    }
}