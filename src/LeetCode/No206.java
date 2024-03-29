package LeetCode;

/*
    反转一个单链表。

示例:

输入: 1->2->3->4->5->NULL
输出: 5->4->3->2->1->NULL
进阶:
你可以迭代或递归地反转链表。你能否用两种方法解决这道题？

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/reverse-linked-list
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No206 {
    // 迭代
    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        // 设定一个空节点来存放
        ListNode pre = null;
        while(cur!=null){
            ListNode nextTemp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nextTemp;
        }
        return pre;
    }
    // 递归算法
    public ListNode reverseList2(ListNode head){
        // 递归的中止判定
        if (head == null || head.next == null){
            return head;
        }
        // 开始递归
        ListNode cur = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return cur;
    }
}
