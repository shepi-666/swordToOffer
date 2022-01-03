package day20.offer33_verifyPostorder;

public class MySolution {
    public boolean verifyPostorder(int[] postorder) {
        if (postorder.length < 2) return true;
        return verifyPostorder(postorder, 0, postorder.length - 1);
    }

    public boolean verifyPostorder(int[] postorder, int l, int r) {
        // 如果l > r 也就是说当前检查已经越过了叶子节点仍然没有出现不合法的节点，就返回true
        if (l > r) return true;
        // 对于后序遍历的数，最后一个节点肯定是根节点
        int rootVal = postorder[r];
        int k = l;
        // 对于一个二叉排序数，左子树的值一定是小于根节点的
        while (postorder[k] < rootVal) k++;
        // 此时k指向的是右子树的第一个节点
        // 因为右子树的节点都是大于根节点的，所以我们需要在右子树中排查是否有小于根节点的值
        for (int j = k; j < r; j++) {
            if (postorder[j] < rootVal) return false;
        }

        // 如果对于当前的根节点，左右子树都是没有问题的，遍历左右子树
        return verifyPostorder(postorder, l, k-1) && verifyPostorder(postorder, k, r-1);
    }
}
