package LeetCode;

/**
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点
 * 输入：head = [1,2,6,3,4,5,6], val = 6
 * 输出：[1,2,3,4,5]
 * 示例 2：
 *
 * 输入：head = [], val = 1
 * 输出：[]
 * 示例 3：
 *
 * 输入：head = [7,7,7,7], val = 7
 * 输出：[]
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-linked-list-elements
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No203 {
    public static void main(String[] args) {

    }
    public ListNode removeElements(ListNode head, int val) {
        if(head == null){
            return null;
        }
        ListNode newListNode = new ListNode(0);
        newListNode.next = head;
        ListNode prev = newListNode;
        while(prev.next != null){
            if(prev.next.val == val){
                prev.next = prev.next.next;
            }else{
                prev = prev.next;
            }

        }
        return newListNode.next;

    }
    // 递归解法
    public ListNode removeElements2(ListNode head, int val) {
        if (head == null){
            return null;
        }
        head.next = removeElements2(head.next,val);
        return head.val == head.next.val ? head.next : head;
    }

}
