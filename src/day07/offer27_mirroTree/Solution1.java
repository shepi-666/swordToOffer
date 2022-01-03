package day07.offer27_mirroTree;

public class Solution1 {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) return null;
        // 暂存左子节点
        TreeNode temp = root.left;

        // 经过这一步交换的之后，原本树的左子节点变为右子节点
        root.left = mirrorTree(root.right);


        root.right = mirrorTree(temp);

        return root;

    }
}
