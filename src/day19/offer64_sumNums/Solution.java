package day19.offer64_sumNums;

public class Solution {
    public int sumNums(int n) {
        /*
        if (n == 1) return 1;
        else
            return sumNums(n-1) + n;
        */

        // 观察上述代码我们发现，我们需要在n==1的时候停止递归
        // 因此我们可以使用短路与&&的方式阻止递归
        int sum = 0;
        boolean flag = n > 0 && (sum = sumNums(n - 1) + n) > 0;
        return sum;

    }
}
