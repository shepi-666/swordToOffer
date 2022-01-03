package day15.offer54_KthLargest;

import day15.offer34_pathSum.TreeNode;

public class Solution {
    /**
     * 二叉搜索树的前序遍历,优化方式就是使用一个计数器，在节点为K的时候就结束
     * @param root
     * @param k
     * @return
     */
    private int ans = 0, cnt = 0;
    public int kthLargest(TreeNode root, int k) {
        dfs(root, k);
        return ans;
    }
    private void dfs(TreeNode root, int k) {
        if(root == null) return ;
        dfs(root.right, k);
        if(++cnt == k) {
            ans = root.val;
        }
        dfs(root.left, k);
    }
}
