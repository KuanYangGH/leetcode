package medium.question148;

import java.util.ArrayList;
import java.util.List;

/**
 *  Sort List
 *  Sort a linked list in O(n log n) time using constant space complexity.
 * @author yangkuan
 * @date 2018/09/10
 */
public class Solution {
    /**
     * Definition for singly-linked list.
     */
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode sortList(ListNode head) {
        if(head==null){
            return head;
        }
        List<Integer> list = new ArrayList<>();
        ListNode tmp = head;
        while (tmp!=null){
            list.add(tmp.val);
            tmp = tmp.next;
        }
        mergeSort(list,0,list.size()-1);
        tmp = head;
        for(int i=0;i<list.size();i++){
            tmp.val = list.get(i);
            tmp = tmp.next;
        }
        return head;
    }
    public void mergeSort(List<Integer> list,int startIndex,int endIndex){
        if(startIndex==endIndex){
            return;
        }
        mergeSort(list,startIndex,(startIndex+endIndex)/2);
        mergeSort(list,(startIndex+endIndex)/2+1,endIndex);
        merge(list,startIndex,(startIndex+endIndex)/2,endIndex);
    }
    public void merge(List<Integer> list,int startIndex,int midIndex,int endIndex){
        List<Integer> tmp = new ArrayList<>();
        int i = startIndex;
        int j = midIndex+1;
        while (i<=midIndex&&j<=endIndex){
            if(list.get(i)<list.get(j)){
                tmp.add(list.get(i++));
            }
            else {
                tmp.add(list.get(j++));
            }
        }
        while (i<=midIndex){
            tmp.add(list.get(i++));
        }
        while (j<=endIndex){
            tmp.add(list.get(j++));
        }
        for(int k=0;k<tmp.size();k++){
            list.set(k+startIndex,tmp.get(k));
        }
    }

    public void test(){
        ListNode head = new ListNode(4);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(5);
        ListNode node4 = new ListNode(1);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        head = sortList(head);
        while (head!=null){
            System.out.print(head.val+" ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        new Solution().test();
    }
}
