package day13.offer21_exchange;

public class Solution {
    public int[] exchange(int[] nums) {
        if (nums == null) return null;
        if (nums.length <= 1) return nums;

        int temp;
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            while (i < j && nums[i] % 2 == 1) i++;
            while (i < j && nums[j] % 2 == 0) j--;
            temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        return nums;
    }

}
