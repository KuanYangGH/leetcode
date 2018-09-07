package medium.question147;

/**
 * Insertion Sort List
 * Sort a linked list using insertion sort.
 * @author yangkuan
 * @date 2019/09/06
 */
class Solution {
    /**
     * Definition for singly-linked list.
     */
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }
    public ListNode insertionSortList(ListNode head) {

        if(head==null||head.next==null){
            return head;
        }
        ListNode index = head;
        while (index!=null){
            //取出节点
            ListNode node = index.next;
            if(node==null){
                break;
            }


            ListNode fast = head;
            ListNode slow = null;
            while (fast.val<node.val&&fast!=node){
                slow = fast;
                fast = fast.next;
            }
            if(fast!=node){
                index.next = index.next.next;
                if(slow!=null){
                    slow.next = node;
                }
                else {
                   head = node;
                }
                node.next = fast;
            }
            else {
                index = index.next;
            }
        }
        return head;
    }

    public void test(){
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(3);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        head = insertionSortList(head);
        while (head!=null){
            System.out.print(head.val+" ");
            head = head.next;
        }
    }
    public static void main(String[] args) {
        new Solution().test();
    }
}