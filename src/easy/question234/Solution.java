package easy.question234;

import javax.print.attribute.standard.NumberUp;

/**
 * Palindrome Linked List
 * Given a singly linked list, determine if it is a palindrome.
 * Example 1:
 * Input: 1->2
 * Output: false
 * Example 2:
 * Input: 1->2->2->1
 * Output: true
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
     * 我的思路是把链表均分成两段，前一段翻转之后，与后一段逐一比较
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        if (head==null||head.next==null){
            return true;
        }
        // 获取链表长度
        ListNode node = head;
        int len = 0;
        while (node!=null){
            len++;
            node = node.next;
        }
        // 获取前半段和后半段的头节点
        node = head;
        for(int i=0;i<len/2-1;i++){
            node = node.next;
        }
        ListNode head1 = head;
        ListNode head2 = node.next;
        //前半段中的尾节点的next设置为null
        node.next = null;
        // 判断链表长度奇偶
        if(len%2!=0) head2 = head2.next;
        // 翻转前半段
        head1 = reverseLinkedList(head1);

        while (head1!= null){
            if(head1.val!=head2.val){
                return false;
            }
            head1 = head1.next;
            head2 = head2.next;
        }
        return true;
    }

    private ListNode reverseLinkedList(ListNode head){
        ListNode last = null;
        ListNode current = head;
        ListNode next = current.next;

        while (current!=null){
            current.next = last;

            last = current;
            current = next;
            if(current==null){
                return last;
            }
            next = next.next;
        }
        return last;
    }
    private void test(){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        node1.next = node2;
//        node1 = reverseLinkedList(node1);
        System.out.println(isPalindrome(node1));
    }

    public static void main(String[] args) {
        new Solution().test();
    }
}
