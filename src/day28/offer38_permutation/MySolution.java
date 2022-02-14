package day28.offer38_permutation;

import java.util.HashSet;
import java.util.Set;

/**
 * 输入一个字符串，打印出该字符串中字符的所有排列
 *
 * 假设字符串一共有n个字符，那么一共就有n！种可能
 */
public class MySolution {
    public String[] permutation(String s) {
        if (s == null || s.length() == 0) return new String[0];
        if (s.length() == 1) return new String[]{s};

        // 将字符串转换为字符数组
        char[] chars = s.toCharArray();
        // 结果集为HashSet，为了去重方便
        Set<String> res = new HashSet<>();
        // 用来记录字符是否被访问的数组
        boolean[] flags = new boolean[chars.length];
        dfs(res, "", chars, flags);
        return res.toArray(new String[0]);
    }

    private void dfs(Set<String> res, String s, char[] chars, boolean[] flags) {
        if (s.length() == chars.length) {
            res.add(s);
            return;
        }

        for (int i = 0; i < chars.length; i++) {
            if (flags[i]) continue;
            flags[i] = true;
            dfs(res, s + chars[i], chars, flags);
            flags[i] = false;
        }
    }
}
