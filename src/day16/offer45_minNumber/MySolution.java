package day16.offer45_minNumber;


import java.util.Arrays;
import java.util.Comparator;

/**
 * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，
 * 打印能拼接出的所有数字中最小的一个。
 *
 * 这道题虽然看上去是一个字符串拼接问题，但是本质上是一个排序问题
 * 定义排序规则：
 * x + y > y + x ==> x > y
 * x + y < y + x ==> x < y
 * 我们利用上面的排序规则，重写comparable接口即可
 */
public class MySolution {
    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        // 为了不对原来的数据做出改变，将原来的整形变为字符串
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }

        // 使用Arrays.sort()方法实现排序
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1 + o2).compareTo(o2 + o1);
            }
        });

        StringBuilder builder = new StringBuilder();
        for (String str :
                strs) {
            builder.append(str);
        }
        return builder.toString();
    }
}
