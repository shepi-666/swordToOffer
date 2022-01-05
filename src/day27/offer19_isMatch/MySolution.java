package day27.offer19_isMatch;

/**
 * 正则表达式匹配：
 * . 任意单个字符
 * * 任意多个字符
 */
public class MySolution {

    /**
     * 使用动态规划
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        int m = s.length() + 1;
        int n = p.length() + 1;
        boolean[][] dp = new boolean[m][n];
        dp[0][0] = true; // 两个空串可以相互匹配

        // 首先对dp数组的第一行初始化
        // dp数组的第一行表示s串的长度为0，这就要求模式串p偶数位为*
        for (int i = 2; i < n; i += 2) {
            if (p.charAt(i - 1) == '*') dp[0][i] = dp[0][i - 2];
        }

        // 状态转移
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // 如果模式串的第j个字符是*
                if (p.charAt(j - 1) == '*') {
                    // * 之前的字符c出现0次，直接将"c*"抹去，看之前的字符是否匹配
                    if (dp[i][j - 2]) dp[i][j] = true;
                    // * 之前的字符和s当前的字符相同
                    else if (p.charAt(j - 2) == s.charAt(i - 1) && dp[i - 1][j]) dp[i][j] = true;
                    // * 之前的字符为.
                    else if (p.charAt(j - 2) == '.' && dp[i - 1][j]) dp[i][j] = true;
                } else {
                    if (s.charAt(i - 1) == p.charAt(j - 1) && dp[i - 1][j - 1]) dp[i][j] = true;
                    else if (p.charAt(j - 1) == '.' && dp[i - 1][j - 1]) dp[i][j] = true;
                }
            }
        }

        return dp[m - 1][n - 1];
    }
}
