package day06.offer32III_levelOrder;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution2 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> retList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return retList;
        }
        queue.add(root);
        Boolean flag = true;
        while (!queue.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                temp.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            if (flag) {
                retList.add(temp);
            } else {
                ArrayList<Integer> temp2 = new ArrayList<>();
                for (int i = temp.size() - 1; i >= 0; i--) {
                    temp2.add(temp.get(i));
                }
                retList.add(temp2);
            }
            flag = !flag;
        }
        return retList;
    }
}
