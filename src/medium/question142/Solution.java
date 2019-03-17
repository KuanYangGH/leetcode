package medium.question142;

/**
 * Linked List Cycle II
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 * To represent a cycle in the given linked list, we use an integer pos
 * which represents the position (0-indexed) in the linked list where tail connects to.
 * If pos is -1, then there is no cycle in the linked list.
 * Note: Do not modify the linked list.
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
            next = null;
        }
    }
    public ListNode detectCycle(ListNode head) {
        if(head==null||head.next==null) return null;

        ListNode slow = head.next;
        ListNode fast = head.next.next;
        while (slow!=fast){
            if(fast==null||fast.next==null){
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode node = head;
        while (node!=slow){
            node = node.next;
            slow = slow.next;
        }
        return node;
    }

    public void test(){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;
        System.out.println(detectCycle(node1).val);
    }
    public static void main(String[] args) {
        new Solution().test();
    }
}
