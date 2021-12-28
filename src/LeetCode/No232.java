package LeetCode;

import java.util.Stack;

/**
 * 用栈实现队列
 */
public class No232 {
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public No232() {
        stack1 = new Stack<>(); //入栈
        stack2 = new Stack<>(); //出栈
    }

    public void push(int x) {
        stack1.push(x);
    }

    public int pop() {
        // 如果stack2不为空，则stack2顶部元素出栈
        if (stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public int peek() {
        // 如果stack2不为空，则stack2顶部元素出栈
        if (stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }

        return stack2.peek();
    }

    public boolean empty() {
        return stack2.isEmpty() && stack1.isEmpty();
    }
}
