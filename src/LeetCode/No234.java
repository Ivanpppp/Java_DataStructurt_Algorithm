package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
请判断一个链表是否为回文链表。

示例 1:

输入: 1->2
输出: false
示例 2:

输入: 1->2->2->1
输出: true
进阶：
你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/palindrome-linked-list
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No234 {

    public static void main(String[] args) {
        
    }

    public static boolean isPalindrome(ListNode head) {
        List<Integer> res = new ArrayList<>();
        ListNode cur = head;
        while (cur!=null){
            res.add(cur.val);
            cur = cur.next;
        }
        int first = 0;
        int end = res.size() - 1;
        while (first < end){
            if (!res.get(first).equals(res.get(end))){
                return false;
            }
            first++;
            end--;
        }
        return true;
    }
}
