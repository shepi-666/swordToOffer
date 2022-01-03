package day15.offer54_KthLargest;

import day15.offer34_pathSum.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class MySolution {
    /**
     * 二叉搜索树的前序遍历
     * @param root
     * @param k
     * @return
     */
    public int kthLargest(TreeNode root, int k) {
        List<Integer> temp = new ArrayList<>();
        dfs(root, temp);
        return temp.get(temp.size() - k);
    }

    public void dfs(TreeNode root, List<Integer> temp) {
        if (root == null) return;
        dfs(root.left, temp);
        temp.add(root.val);
        dfs(root.right, temp);
    }
}
