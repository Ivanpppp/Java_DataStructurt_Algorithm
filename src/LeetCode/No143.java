package LeetCode;

import java.util.ArrayList;
import java.util.List;

/*
给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…

你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。

示例 1:

给定链表 1->2->3->4, 重新排列为 1->4->2->3.
示例 2:

给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/reorder-list
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No143 {
    
    public void reorderList(ListNode head) {
        // 重建该链表
        if (head == null){
            return;
        }

        List<ListNode> list = new ArrayList<>();
        ListNode node = head;

        // 开始循环
        while (node != null){
            list.add(node);
            node = node.next;
        }

        // 由题意可知，要设定first 和 last两个指针分别指向Lx和Ln-x
        int first = 0;
        int last = list.size() - 1;
        while(first < last){
            list.get(first).next = list.get(last);
            first+=1;
            if (first == last){
                break;
            }
            list.get(last).next = list.get(first);
            last-=1;
        }
        list.get(first).next = null;
    }
}
