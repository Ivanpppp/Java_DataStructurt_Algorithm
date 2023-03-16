package LeetCode;

import java.util.*;

public class No142 {
    /**
     * 给定一个链表的头节点 head，返回链表开始入环的第一个节点。如果链表无环，则返回null。
     * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
     * 不允许修改 链表
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        Set<ListNode> map = new HashSet<>();
        int index = 0;
        ListNode pre = head;
        boolean flag = false;// 判断是否有环
        while (head.next != null){
            if (map.contains(head)){
                flag = true;
                break;
            }
            map.add(head);
            head = head.next;
            index++;
        }
        if (!flag) return null;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        return pre;
    }

    // 双指针
    public ListNode detectCycle2(ListNode head){
        if (head == null){
            return null;
        }
        ListNode fast = head,slow = head;
        while (fast != null){
            slow = slow.next;
            if (fast.next != null){
                fast = fast.next.next;
            }else {
                return null;
            }
            if (fast == slow){
                ListNode ptr = head;
                while (ptr != slow){
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }
        }
        return null;
    }
}
