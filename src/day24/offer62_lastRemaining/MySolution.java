package day24.offer62_lastRemaining;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 从数字0开始，每次从这个圆圈里删除第m个数字（删除后从下一个数字开始计数）。
 * 求出这个圆圈里剩下的最后一个数字。
 */
public class MySolution {
    /**
     * 约瑟夫环，环形队列
     * @param n
     * @param m
     * @return
     */
    public int lastRemaining(int n, int m) {
        List<Integer> temp = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            temp.add(i, i);
        }
        int count = 0;
        while (temp.size() > 1) {
            count = (count + m - 1) % temp.size();
            temp.remove(count);
        }
        return temp.get(0);
    }

    @Test
    public void test(){
        System.out.println(lastRemaining(5, 3));
    }
}
