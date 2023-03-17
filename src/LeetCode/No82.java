package LeetCode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class No82 {
    /**
     * 给定一个已排序的链表的头 head，删除原始链表中所有重复数字的节点，只留下不同的数字 。返回已排序的链表 。
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null){
            if (cur.next.val == cur.next.next.val){
                int x = cur.next.val;
                while (cur.next != null && cur.next.val == x){
                    cur.next = cur.next.next;
                }
            }else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}
