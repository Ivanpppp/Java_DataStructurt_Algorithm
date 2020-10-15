package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class No116 {

    // Definition for a Node.
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public static void main(String[] args) {

    }
    public Node connect(Node root){
        // 层序遍历
        if (root == null){
            return root;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node cur = queue.poll();

                if (i < size - 1){
                    // 先进先出，取出的cur如果不是当前的最后的元素，则指向当前的头部元素即可
                    cur.next = queue.peek();
                }

                if (cur.left != null){
                    queue.offer(cur.left);
                }

                if (cur.right != null){
                    queue.offer(cur.right);
                }
            }
        }
        return root;
    }
}
