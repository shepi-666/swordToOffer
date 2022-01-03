package day20.offer33_verifyPostorder;

import java.util.Stack;

/**
 * 使用单调栈的方法
 */
public class Solution {
    public boolean verifyPostorder(int[] postorder) {
        // 二叉搜索树的root --> right --> left
        // 前面的半部分应当是单调递增的
        Stack<Integer> stack = new Stack<>();
        // 这个变量记录的是左子树开始的根节点
        int preElem = Integer.MAX_VALUE;
        for (int i = postorder.length - 1; i >= 0; i--) {
            if (postorder[i] > preElem) return false;
            while (!stack.isEmpty() && stack.peek() > postorder[i]) {
                preElem = stack.pop();
            }
            stack.push(postorder[i]);
        }
        return true;
    }
}
