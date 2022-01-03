package day04.offer03_findRepeatNumber;

public class Solution2 {
    /**
     * 时间复杂度: o(N)
     * 在最坏的情况下，每一个元素都需要交换两次才能到正确的位置：n * 2
     * 全部交换完毕之后，for循环只是循环但是不执行while，（n - 1)
     * 所以时间复杂度就是: o(N)
     * 空间复杂度：o(1)
     * @param nums
     * @return
     */
    public int findRepeatNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                // 如果当前元素的真正位置和真正位置的元素的值相等
                // 就说明出现了重复的值，返回
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                } else {
                    // 将当前不在位置的元素交换到他的真正位置
                    int temp = nums[i];
                    nums[i] = nums[temp];
                    nums[temp] = temp;
                }
                // 交换之后的元素，应当是下标的值等于元素的值
            }
        }
        return -1;
    }
}
