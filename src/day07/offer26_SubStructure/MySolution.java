package day07.offer26_SubStructure;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class MySolution {

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }
        List<Boolean> flags = new ArrayList<>(15000);

        compareTreeNode(A, B, flags, 0);

        return flags.contains(true);

    }

    public void compareTreeNode(TreeNode A, TreeNode B, List<Boolean> flags, Integer count) {
        flags.add(count, false);

        if (B == null) {
            flags.add(count, true);
            return;
        }
        if (A == null) {
            flags.add(count, false);
            return;
        }
        if (A.val == B.val) {
            compareTreeNode(A.left, B.left, flags, count);
            compareTreeNode(A.right, B.right, flags, count);
        }
        if (!flags.get(count)) {
            compareTreeNode(A.left, B, flags, count + 1);
            compareTreeNode(A.right, B, flags, count + 1);
        }
    }

    @Test
    public void test() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(1);

        node1.left = node2;
        node1.right = node3;

        node4.left = node5;


        System.out.println(isSubStructure(node1, node4));
    }


}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode (int x) { val = x; }
}
