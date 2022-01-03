package day22.offer56I_singleNumbers;

/**
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。
 * 请写程序找出这两个只出现一次的数字。
 * 要求时间复杂度是O(n)，空间复杂度是O(1)。
 */
public class MySolution {
    public int[] singleNumbers(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }

        // 此时得到的res结果就是两个数的异或结果
        // 使用下面的这个操作得出最低位的1
        // 表示这两个单数在这一位上是不相同的
        int flag = res & (-res);
        int x = 0;
        for (int num : nums) {
            if ((num & flag) == 0) {
                x ^= num;
            }
        }
        return new int[]{x, res ^ x};

    }

}
