package LeetCode;

import java.util.*;

public class No103 {
    public static void main(String[] args) {

    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        boolean isOrderLeft = true;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int n = queue.size();
            Deque<Integer> list = new ArrayDeque<>();
            for (int i = 0; i < n; i++) {
                TreeNode cur = queue.poll();
                if (isOrderLeft){
                    list.offerLast(cur.val);
                }else {
                    list.offerFirst(cur.val);
                }
                if (cur.left!=null){
                    queue.offer(cur.left);
                }
                if (cur.right!=null) {
                    queue.offer(cur.right);
                }
            }
            ans.add(new ArrayList<>(list));
            isOrderLeft = !isOrderLeft;
        }
        return ans;
    }
}
