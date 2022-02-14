package day28.offer37_serializeTree;

import day15.offer34_pathSum.TreeNode;

import java.util.LinkedList;

/**
 * 实现两个函数，分别用来序列化和反序列化二叉树
 */
public class MySolution {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder res = new StringBuilder("[");
        if (root == null) return res.append("]").toString();
        // 层序遍历二叉树
        LinkedList<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        while (nodes.size() > 0) {
            TreeNode node = nodes.poll();
            if (node == null) {
                res.append("null,");
            } else {
                res.append(node.val).append(",");
                nodes.add(node.left);
                nodes.add(node.right);
            }
        }
        res.deleteCharAt(res.length() - 1);
        return res.append("]").toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("[]")) return null;
        String s = data.substring(1, data.length() - 1);
        String[] nodeStr = s.split(",");
        // 建立根节点
        TreeNode root = new TreeNode(Integer.parseInt(nodeStr[0]));
        int index = 1; // 用来表示子节点的在数组中的坐标
        // 创建队列
        LinkedList<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        while (nodes.size() > 0) {
            TreeNode node = nodes.poll();
            if (!nodeStr[index].equals("null")) {
                // 将左子节点拼接上
                node.left = new TreeNode(Integer.parseInt(nodeStr[index]));
                // 将左孩子添加到队列中
                nodes.add(node.left);
            }
            // 坐标自增
            index ++;
            if (!nodeStr[index].equals("null")) {
                // 右孩子的处理
                node.right = new TreeNode(Integer.parseInt(nodeStr[index]));
                nodes.add(node.right);
            }
            // 自增
            index ++;
        }
        return root;
    }
}
