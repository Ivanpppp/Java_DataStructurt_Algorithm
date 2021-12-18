package Ivan.JianZhiOffer;


import java.util.ArrayList;
import java.util.List;

/**
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 *
 *
 *
 * 示例 1：
 *
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 */
public class No066 {

    public int[] reversePrint(ListNode head) {
        List<Integer> list = new ArrayList<>();
        if(head == null) return new int[]{};
        while(head != null){
            list.add(head.val);
            head = head.next;
        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(list.size() - i -1);
        }
        return ans;
    }
}
