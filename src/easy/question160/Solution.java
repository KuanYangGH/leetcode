package easy.question160;

/**
 * Intersection of Two Linked Lists
 * Write a program to find the node at which the intersection of two singly linked lists begins.
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

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode nodeA = headA;
        int lengthA = 0;
        while (nodeA!=null){
            lengthA ++;
            nodeA = nodeA.next;
        }
        ListNode nodeB = headB;
        int lengthB = 0;
        while (nodeB!=null){
            lengthB ++;
            nodeB = nodeB.next;
        }
        nodeA = headA;
        nodeB = headB;
        if(lengthA>lengthB){
            for(int i=0;i<lengthA-lengthB;i++){
                nodeA = nodeA.next;
            }
        }
        else {
            for(int i=0;i<lengthB-lengthA;i++){
                nodeB = nodeB.next;
            }
        }

        while (nodeA!=nodeB){
            nodeA = nodeA.next;
            nodeB = nodeB.next;
        }
        return nodeA;
    }

    private void test(){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);

        node1.next = node2;
        node2.next = node3;
        node3.next = node6;

        node4.next = node5;
        node5.next = node6;

        node5.next = node6;
        node6.next = node7;

        ListNode intersectionNode = getIntersectionNode(node1,node4);
        System.out.println(intersectionNode.val);
    }

    public static void main(String[] args) {
        new Solution().test();
    }
}
