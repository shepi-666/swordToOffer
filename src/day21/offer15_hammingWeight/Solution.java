package day21.offer15_hammingWeight;

public class Solution {
    /*
    * n         :1 0 0 1 0 1 0 0
    * n - 1     :1 0 0 1 0 0 1 1
    * n & (n-1) :1 0 0 1 0 0 0 0
    * 这样的话就每一次都会消除一个1
    * */
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n - 1);
        }
        return count;
    }
}
