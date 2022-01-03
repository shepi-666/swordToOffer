package day07.offer26_SubStructure;

public class Solution {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }

        return compareTreeNode(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    public boolean compareTreeNode(TreeNode A, TreeNode B) {
        if (B == null) return true;
        if (A == null) return false;
        return A.val == B.val && compareTreeNode(A.left, B.left) && compareTreeNode(A.right, B.right);
    }
}
