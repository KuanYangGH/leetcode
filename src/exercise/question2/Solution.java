package exercise.question2;

/**
 * 合并有序链表
 *
 * @author yangkuan
 */
public class Solution {
    /**
     * Definition for singly-linked list.
     */
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 递归
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode node = null;
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            node = l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            node = l2;
        }
        return node;
    }

    /**
     * 非递归
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoListsNoR(ListNode l1, ListNode l2) {
        if(l1==null) return l2;
        if(l2==null) return l1;
        ListNode head = new ListNode(-1);
        ListNode node = head;
        while (l1!=null&&l2!=null){
            if(l1.val<l2.val){
                node.next = l1;
                l1 = l1.next;
            }
            else {
                node.next = l2;
                l2 = l2.next;
            }
            node = node.next;
        }
        node.next = l1==null?l2:l1;
        return head.next;
    }
}
