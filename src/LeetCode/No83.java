package LeetCode;

/**
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。
 *
 * 返回同样按升序排列的结果链表。
 */
public class No83 {
    public static void main(String[] args) {

    }
    // 迭代
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode pre = head;
        while (head.next != null){
            if (head.val == head.next.val){
                head.next = head.next.next;
            }else {
                head = head.next;
            }
        }
        return pre;
    }
}
