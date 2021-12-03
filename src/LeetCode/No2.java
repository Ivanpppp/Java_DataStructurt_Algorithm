package LeetCode;

/**
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * 示例 2：
 *
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 * 示例 3：
 *
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 *  
 *
 * 提示：
 *
 * 每个链表中的节点数在范围 [1, 100] 内
 * 0 <= Node.val <= 9
 * 题目数据保证列表表示的数字不含前导零
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No2 {
    public static void main(String[] args) {

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode(0);
        ListNode ans = listNode;
        // carry表示进位
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0){
            int tmp1 = l1!=null ? l1.val : 0;
            int tmp2 = l2!=null ? l2.val : 0;
            int sum = tmp1 + tmp2 + carry;
            carry = sum > 10 ? 1:0;
            listNode.next = new ListNode(sum % 10);
            listNode = listNode.next;
            if(l1.next != null) l1 = l1.next;
            if(l2.next != null) l2 = l2.next;

        }
        return ans.next;

    }
}
