package LeetCode;

/*
给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。

示例：

给定一个链表: 1->2->3->4->5, 和 n = 2.

当删除了倒数第二个节点后，链表变为 1->2->3->5.
说明：

给定的 n 保证是有效的。

进阶：

你能尝试使用一趟扫描实现吗？

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No19 {
    public static void main(String[] args) {

    }
    public ListNode removeNthFromEnd(ListNode head, int n){
        // 特判
        if (head == null){
            return null;
        }
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode fast = pre;
        ListNode slow = pre;

        // 快的先走n步
        for (int i = 0; i < n + 1; i++) {
            fast = fast.next;
        }

        while (fast!=null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return pre.next;

    }
}
