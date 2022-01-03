package day24.offer57II_findContinuousSequence;


import java.util.ArrayList;
import java.util.List;

/**
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列
 */
public class MySolution {
    /**
     * 使用滑动窗口【双指针】
     * @param target
     * @return
     */
    public int[][] findContinuousSequence(int target) {
        int i = 1;
        int j = 1;
        int sum = 1;
        List<int[]> res = new ArrayList<>();
        while (i <= target / 2) {
            if (sum <target) {
                j++;
                sum += j;
            } else if (sum > target) {
                sum -= i;
                i++;
            } else {
                int[] temp = new int[j - i + 1];
                temp[0] = i;
                for (int k = 1; k < temp.length; k++) {
                    temp[k] = temp[k - 1] +1;
                }
                res.add(temp);

                // 记录完数据之后，需要将左边界向右移动
                sum -= i;
                i++;
            }
        }
        return res.toArray(new int[res.size()][]);

    }

}
