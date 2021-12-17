package Ivan.JianZhiOffer;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 *
 *  
 *
 * 示例:
 *
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.min();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.min();   --> 返回 -2.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No30 {
    Stack<Integer> list;
    // 辅助栈list2,用于维护最小值
    Stack<Integer> list2;
    public No30() {
        list = new Stack<>();
        list2 = new Stack<>();
    }

    public void push(int x) {
        list.push(x);
        if (list2.empty() || x <= list2.peek()) {
            // 当栈2为空，或是栈2顶端元素比新入栈1的元素小的时候，新元素也入栈2
            list2.push(x);
        }
    }

    public void pop() {
        if (list.pop().equals(list2.peek())){
            list2.pop();
        }
    }

    public int top() {
        return list.peek();
    }

    public int min() {
        return list2.peek();
    }
}
