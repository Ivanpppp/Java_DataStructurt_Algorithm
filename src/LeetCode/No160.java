package LeetCode;

import java.util.HashSet;
import java.util.Set;

public class No160 {
    /**
     * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        while (headA.next != null){
            set.add(headA);
            headA = headA.next;
        }
        while (headB.next != null){
            if (set.contains(headB)){
                return headB;
            }
            set.add(headB);
            headB = headB.next;
        }
        return null;
    }
}
