package day15.offer34_pathSum;

import java.util.ArrayList;
import java.util.List;


/**
 * 找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 */
public class MySolution {
    public List<List<Integer>> pathSum(TreeNode root, int target) {

        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        dfs(res, target, root, 0, new ArrayList<>());
        return res;
    }

    public void dfs(List<List<Integer>> res, int target, TreeNode root, int index, List<Integer> temp) {

        if (root == null) return;
        temp.add(root.val);
        if (root.right == null && root.left == null && index + root.val == target) {
            res.add(new ArrayList<Integer>(temp));
            temp.remove(temp.size()-1);
            return;
        }

        dfs(res, target, root.left, index + root.val, temp);
        dfs(res, target, root.right, index + root.val, temp);
        //  将刚添加的节点删除
        temp.remove(temp.size() - 1);

    }
}
