package day20.offer07_buildTreee;

import day15.offer34_pathSum.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 重建二叉树：使用分值算法
 */
public class MySolution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return partial(map, preorder, 0, 0, inorder.length - 1);
    }

    /**
     *
     * @param map
     * @param preorder
     * @param index 表示子树根节点的索引
     * @param l 表示子树在中序遍历中的左边的索引
     * @param r 表示子树在前序遍历中的右边界索引
     * @return
     */
    public TreeNode partial(Map<Integer, Integer> map, int[] preorder, int index, int l, int r) {

        if (l > r) return null; // 相等就是自己
        // 首先得出根节点的在中序遍历中的位置
        Integer i = map.get(preorder[index]);
        TreeNode node = new TreeNode(preorder[index]);

        // 左子树的根节点在前序遍历中的坐标为 index + 1
        node.left = partial(map, preorder, index + 1, l, i - 1);
        // 右边子树的根节点在前序遍历中的坐标为：i - l(左节点的数量) + index + 1(根节点的坐标)
        node.right = partial(map, preorder, i - l + index + 1, i + 1, r);
        return node;

    }
}
