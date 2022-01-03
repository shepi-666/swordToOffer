package day07.offer28_symmetricTree;

public class MySolution {
    /**
     * 先获取左子节点的镜像，将判断左孩子和右孩子是否相同
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        // 首先应当调用方法获取二叉树的镜像
        TreeNode leftNode = getMirror(root.left);
        TreeNode rightNode = root.right;
        // 比较这两个子树书否相等
        return compareTree(leftNode, rightNode);

    }

    public TreeNode getMirror(TreeNode root) {
        if (root == null) return null;
        TreeNode temp = root.left;

        root.left = getMirror(root.right);
        root.right = getMirror(temp);

        return root;
    }

    public boolean compareTree(TreeNode A, TreeNode B) {
        if (A == null && B == null ) return true;
        if (A == null || B == null) return false;
        return A.val == B.val && compareTree(A.left, B.left) && compareTree(A.right, B.right);
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode (int x) { val = x; }
}