package day14.offer13_movingCount;

import org.junit.Test;

public class Solution {
    public int movingCount(int m, int n, int k) {
        int i = 0;
        int j = 0;
        int[] res = new int[1];
        boolean[][] isVisited = new boolean[m][n];
        dfs(m, n, k, i, j, isVisited, res);
        return res[0];
    }

    public void dfs(int m, int n, int k, int i, int j, boolean[][] isVisited, int[] res) {
        if (i < 0 || j < 0 || i == m || j == n || isVisited[i][j]
                || (i % 10 + i / 10 + j % 10 + j / 10 > k)) {
            return;
        }
        // 当前坐标是可达的
        isVisited[i][j] = true;
        res[0] = res[0] + 1;
        dfs(m, n, k, i + 1, j, isVisited, res);
        dfs(m, n, k, i - 1, j, isVisited, res);
        dfs(m, n, k, i, j + 1, isVisited, res);
        dfs(m, n, k, i, j - 1, isVisited, res);
    }

    @Test
    public void test() {
        System.out.println(movingCount(3, 1, 0));
    }
}
