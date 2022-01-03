package day05.offer11_minRotateArray;

import org.junit.Test;

/**
 * 请返回旋转数组的最小元素
 */
public class MySolution {
    /**
     * 使用二分法来查找交界处
     * @param numbers
     * @return
     */
    public int minArray(int[] numbers) {
        int i = 0; int j = numbers.length - 1;
        int mid;
        while (i < j) {
            mid = (i + j) / 2;
            if (numbers[mid] > numbers[j]) {
                i = mid + 1;
            } else if (numbers[mid] < numbers[j]){
                j = mid;
            } else {
                // 当中间索引值元素等于最右边元素的时候，说明元素中有重复
                // 将最右端的元素左移以为，达到去重的效果
                j--;
            }
        }
        return numbers[j];
    }

    @Test
    public void test() {
        int[] nums = {3, 3, 1, 3};
        System.out.println(minArray(nums));
    }
}
