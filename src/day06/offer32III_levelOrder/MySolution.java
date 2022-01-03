package day06.offer32III_levelOrder;

import java.util.*;

/**
 * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，
 * 第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推
 */
public class MySolution {
    /**
     * 解题思路：
     * 使用一个队列和一个栈来实现这
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> retList = new ArrayList<>();
        if (root == null) {
            return retList;
        }


        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        stack1.push(root);
        return levelOrder(stack1, stack2, retList, true);
    }

    public List<List<Integer>> levelOrder(Stack<TreeNode> stack1,
                                          Stack<TreeNode> stack2,
                                          List<List<Integer>> retList,
                                          Boolean flag
                                          ) {
        List<Integer> temp = new ArrayList<>();
        if (stack1.isEmpty()) return retList;
        while (!stack1.isEmpty()) {
            TreeNode node = stack1.pop();
            temp.add(node.val);
            if (flag) {
                if (node.left != null) stack2.push(node.left);
                if (node.right != null) stack2.push(node.right);
            } else {
                if (node.right != null) stack2.push(node.right);
                if (node.left != null) stack2.push(node.left);
            }
        }
        retList.add(temp);
        return levelOrder(stack2, stack1, retList, !flag);
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode (int x) {
        val = x;
    }
}
