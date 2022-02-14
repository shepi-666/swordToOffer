package day28.offer44_findNthDigit;

public class Solution2 {
    public int findNthDigit(int n) {
        long start = 1; // 数字的起始
        int digit = 1; // 数字的位数
        long count = 9; // 数字的总位数
        while (n > count) {
            n = (int) (n - count);
            digit = digit + 1;
            start = start * 10; // 1, 10, 100
            count = digit * start * 9;
        }
        long num = start + (n - 1) / digit; // 定位在哪一个数字
        int index = (n - 1) % digit; // 定位在数字的哪一位
        return Long.toString(num).charAt(index) - '0';


    }
}
