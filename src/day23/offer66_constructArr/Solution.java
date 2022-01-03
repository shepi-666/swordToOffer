package day23.offer66_constructArr;

import org.junit.Test;

import java.util.Arrays;

public class Solution {
    public int[] constructArr(int[] a) {
        if (a == null || a.length == 0) return a;
        int[] left = new int[a.length];
        left[0] = a[0];
        int[] right = new int[a.length];
        right[a.length - 1] = a[a.length-1];
        int[] res = new int[a.length];

        for (int i = 1; i < a.length; i++) {
            left[i] = left[i - 1] * a[i];
        }
        for (int i = a.length-2; i >= 0; i--) {
            right[i] = right[i + 1] * a[i];
        }

        for (int i = 0; i < a.length; i++) {
            if (i == 0) {
                res[i] = right[i + 1];
            } else if (i == a.length - 1) {
                res[i] = left[i - 1];
            } else {
                res[i] = left[i - 1] * right[i +1];
            }
        }

        return res;
    }

    @Test
    public void testMethod() {
        System.out.println(Arrays.toString(constructArr(new int[]{1,2,3,4,5})));
    }
}
