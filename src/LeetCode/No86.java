package LeetCode;

/*
给你一个链表和一个特定值 x ，请你对链表进行分隔，使得所有小于 x 的节点都出现在大于或等于 x 的节点之前。

你应当保留两个分区中每个节点的初始相对位置。

 

示例：

输入：head = 1->4->3->2->5->2, x = 3
输出：1->2->2->4->3->5

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/partition-list
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No86 {
    public static void main(String[] args) {

    }
    public ListNode partition(ListNode head, int x) {
        // 新建两个表头
        ListNode small = new ListNode(0);
        ListNode large = new ListNode(0);
        // 分别设定表头
        ListNode smallHead = small;
        ListNode largeHead = large;
        // 遍历链表，把小于的放进small，大于的放进large
        while (head != null) {
            if (head.val < x){
                small.next = head;
                small = small.next;
            }else {
                large.next = head;
                large = large.next;
            }
            head = head.next;
        }
        // large结尾
        large.next = null;
        // small的下一个节点解释largeHead.next
        // 如果是largeHead会导致ListNode large = new ListNode(0)中的0出现在答案中
        small.next = largeHead.next;
        // 返回smallHead.next即可
        return smallHead.next;
    }
}
