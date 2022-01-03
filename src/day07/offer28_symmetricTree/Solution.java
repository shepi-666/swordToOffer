package day07.offer28_symmetricTree;

public class Solution {
    /**
     * 对于左右两个节点，我们应当判断A的左孩子和B的右孩子，A的右孩子和B的左孩子是否相等
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return recursion(root.left, root.right);

    }

    public boolean recursion(TreeNode A, TreeNode B) {
        if (A == null && B == null) return true;
        if (A == null || B == null) return false;
        return A.val == B.val && recursion(A.left, B.right) && recursion(A.right, B.left);
    }
}
