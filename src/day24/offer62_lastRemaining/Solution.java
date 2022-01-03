package day24.offer62_lastRemaining;

public class Solution {
    public int lastRemaining(int n, int m) {
        int ans = 0;
        for (int i = 2; i <= n; i++) {
            // 上一轮坐标为(当前坐标 + 跳数) % 数组长度
            ans = (ans + m) % i;
        }
        return ans;
    }
}
