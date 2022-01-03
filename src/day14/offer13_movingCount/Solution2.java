package day14.offer13_movingCount;

/**
 * 使用递归的方法
 */
public class Solution2 {
    public int movingCount(int m, int n, int k) {
        int i = 0;
        int j = 0;
        boolean[][] isVisited = new boolean[m][n];
        return dfs(m, n, k, i, j, isVisited, 0);
    }

    public int dfs(int m, int n, int k, int i, int j, boolean[][] isVisited, int res) {
        if (i < 0 || j < 0 || i == m || j == n || isVisited[i][j]
                || (i % 10 + i / 10 + j % 10 + j / 10 > k)) {
            // 本坐标不可达，因此增加坐标点为0
            return 0;
        }
        // 当前坐标是可达的
        isVisited[i][j] = true;

        return dfs(m, n, k, i + 1, j, isVisited, res)
            + dfs(m, n, k, i - 1, j, isVisited, res)
            + dfs(m, n, k, i, j + 1, isVisited, res)
            + dfs(m, n, k, i, j - 1, isVisited, res) + 1; // 本坐标可达，因此加1
    }
}
