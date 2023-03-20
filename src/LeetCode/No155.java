package LeetCode;

import javax.sound.sampled.Line;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Map;

public class No155 {
    public static void main(String[] args) {

    }
    class MinStack {
        Deque<Integer> stack;
        Deque<Integer> minStack;
        public MinStack() {
            this.stack = new LinkedList<>();
            this.minStack = new LinkedList<>();
            minStack.add(Integer.MAX_VALUE);
        }

        public void push(int val) {
            stack.push(val);
            minStack.push(Math.min(minStack.peek(),val));
        }

        public void pop() {
            stack.pop();
            minStack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }
}
