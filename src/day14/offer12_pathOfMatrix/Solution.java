package day14.offer12_pathOfMatrix;

public class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null || board[0] == null || board.length == 0 || board[0].length == 0 ||word == null || word.length() ==0) {
            return false;
        }
        boolean[][] isVisited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, word, 0, i, j, isVisited)) return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, String word, int index, int i, int j, boolean[][] isVisited) {
        // 递归返回的条件
        // 1.当前递归的深度等于字符串的长度
        if (index == word.length()) {
            return true;
        }
        // 2. 如果当前递归越过了字符棋盘,或者当前字符已经被访问，或者当前棋盘字符不等于字符串字符，返回false
        if (i < 0 || j < 0 || i == board.length || j == board[0].length || isVisited[i][j] || board[i][j] != word.charAt(index))  {
            return false;
        }
        // 当前路径标记为已经访问
        isVisited[i][j] = true;

        // 对当前路径的下级路径进行递归
        boolean res = dfs(board, word, index + 1, i + 1, j, isVisited)
                    || dfs(board, word, index + 1, i - 1, j, isVisited)
                    || dfs(board, word, index + 1, i, j + 1, isVisited)
                    || dfs(board, word, index + 1, i, j - 1, isVisited);
        // 与当前点有关的所有路径已经被遍历，将该点置位未访问状态
        isVisited[i][j] = false;
        return res;
    }
}
