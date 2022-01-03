package day04.offer03_findRepeatNumber;

public class Solution1 {
    /**
     * 因为数组中的长度值大于数组中值的大小，因此我们可以使用一个新的数组记录原数组中值出现的次数
     * 新数组中的下标表示原数组的值，新数组的值代表原来数组的值出现的次数
     * 时间复杂度：o(n)
     * 空间复杂度：o(n)
     * @param nums
     * @return
     */
    public int findRepeatNumber(int[] nums) {
        int[] array = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            array[nums[i]]++;
            if (array[nums[i]] > 1) {
                return nums[i];
            }
        }
        return -1;
    }
}
