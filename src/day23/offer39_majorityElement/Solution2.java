package day23.offer39_majorityElement;

/**
 * 摩尔投票法，多于一般的那个众数的权重为1
 * 其他的非众数的权重为0
 * 如果权重之和刚好为0，就默认当前字母为众数
 */
public class Solution2 {
    public int majorityElement(int[] nums) {
        int x = 0;
        int votes = 0;
        for (int i = 0; i < nums.length; i++) {
            if (votes == 0) x = nums[i];
            votes += nums[i] == x ? 1 : -1;
        }
        return x;
    }
}
