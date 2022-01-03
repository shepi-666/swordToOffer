package day22.offer56II_singleNumbers;

public class Solution {
    public int singleNumber(int[] nums) {
        int[] bits = new int[32];
        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                bits[i] += num >>> i & 1;
            }
        }
        int res = 0, x = 1;
        for (int i = 0; i < bits.length; i++) {
            if (bits[i] % 3 == 1) {
                res = res + x;
            }
            x = x << 1;
        }
        return res;

    }
}
