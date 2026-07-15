/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = 0;
        ListNode curr = head;
        while(curr!=null) {
            size++;
            curr=curr.next;
        }
        System.out.println(size);
        if(n>size) {
            return head;
        }
        int i=1;
        curr = head;
        ListNode prev = null;
        while(i<=size) {
            if(i==size-n+1) {
                
                if(prev==null) {
                    return head.next;
                } else {
                    prev.next = curr.next;
                    return head;
                }
                
            }
            prev = curr;
            curr = curr.next;
            i++;
        }
        return head;
    }
}
