package day14.offer12_pathOfMatrix;

import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 马踏棋盘算法
 */
public class MySolution {
    public boolean exist(char[][] board, String word) {
        int Y = board.length; // 棋盘的行数
        int X = board[0].length; // 棋盘的列数
        // 创建一个二维数组来表示各个位置是否被访问过
        boolean[][] isVisited = new boolean[Y][X];
        boolean[] finished = new boolean[1];
        for (int i = 0; i < Y; i++) {
            for (int j = 0; j < X; j++) {
                if (board[i][j] == word.charAt(0)) {
                    tourBoard(board, i, j, isVisited, word, 0, finished);
                }
            }
        }

        return finished[0];
    }

    public static void tourBoard(char[][] board, int row, int col,
                                 boolean[][] isVisited, String word, int count,
                                 boolean[] finished) {
        if (count == word.length()) {
            finished[0] = true ;
            return;
        }
        if (finished[0]) return;
        // 获取当前位置的下一个位置的集合
       List<Integer[]> nextPoint = getNext(row, col, board);

        if (board[row][col] == word.charAt(count)) {
            // 如果该点字符等于单词的字符，将该点标记为已经访问
            isVisited[row][col] = true;
            // 将count加1
            count = count + 1;
        }

        // 不管该点是否匹配成功，都向深处进行遍历
        while (nextPoint.size() != 0) {
            Integer[] next = nextPoint.remove(0);
            // 判断该点是否被访问过
            if (!isVisited[next[0]][next[1]]) {
                // 如果该点没有被访问过，并且整个递归没有结束，就对该点递归
                tourBoard(board, next[0], next[1], isVisited, word, count, finished);
            }
        }
    }

    private static List<Integer[]> getNext(int row, int col, char[][] board) {
        List<Integer[]> next = new ArrayList<>();
        int x, y;
        if ((x = row - 1) >= 0 && (y = col) >= 0) {
            Integer[] point = {x, y};
            next.add(point);
        }

        if ((x = row + 1) < board.length && (y = col) >= 0) {
            Integer[] point = {x, y};
            next.add(point);
        }

        if ((y = col + 1) < board[0].length && (x = row) >= 0) {
            Integer[] point = {x, y};
            next.add(point);
        }

        if ((y = col - 1) >= 0 && (x = row) >= 0) {
            Integer[] point = {x, y};
            next.add(point);
        }

        return next;
    }

    @Test
    public void test() {
        char[][] board = {

               {'A', 'B', 'C', 'E'},
               {'S', 'F', 'C', 'S'},
               {'A', 'D', 'E', 'E'},
        };

        String word = "ABCCED";
        System.out.println(exist(board, word));
    }
}
