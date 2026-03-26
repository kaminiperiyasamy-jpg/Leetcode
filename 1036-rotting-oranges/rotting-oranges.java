class Solution {
    public void dfs(int[][] grid, int[][] timeGrid, int i, int j, int day) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length
                || grid[i][j] == 0 || timeGrid[i][j] <= day) {
            return;
        }
        timeGrid[i][j] = day;
        dfs(grid, timeGrid, i + 1, j, day + 1);
        dfs(grid, timeGrid, i - 1, j, day + 1);
        dfs(grid, timeGrid, i, j + 1, day + 1);
        dfs(grid, timeGrid, i, j - 1, day + 1);
    }
    public int orangesRotting(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] timeGrid = new int[row][col];
        for (int i = 0; i < row; i++) {
            Arrays.fill(timeGrid[i], Integer.MAX_VALUE);
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 2) {
                    dfs(grid, timeGrid, i, j, 0);
                }
            }
        }
        int dayCount = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    if (timeGrid[i][j] == Integer.MAX_VALUE)
                        return -1;
                    dayCount = Math.max(dayCount, timeGrid[i][j]);
                }
            }
        }
        return dayCount;
    }
}