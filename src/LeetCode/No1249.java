package LeetCode;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class No1249 {
    public String minRemoveToMakeValid(String s) {
        int n = s.length();
        Stack<Integer> stack = new Stack<>();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (s.charAt(i) == ')') {
                if (stack.isEmpty()) {
                    set.add(i);
                } else {
                    stack.pop();
                }
            }
        }
        while (!stack.isEmpty()) {
            set.add(stack.pop());
        }
        String res = "";
        for (int i = 0; i < n; i++) {
            if (!set.contains(i)) {
                res += s.charAt(i);
            }
        }
        return res;
    }
}
