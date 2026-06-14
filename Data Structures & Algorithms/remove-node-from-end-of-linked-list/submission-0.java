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
        
        int i=0;
        ListNode prev = null;
        curr=head;
        while(i!=size-n) {
            i++;
            prev=curr;
            curr=curr.next;
        }

        if (prev==null) {
            return head.next;
        } else {
            prev.next=curr.next;
            return head;
        }
    }
}
