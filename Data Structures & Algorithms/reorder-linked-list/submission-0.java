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
    public void reorderList(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while(fast.next!=null && fast.next.next!=null) {
            fast=fast.next.next;
            slow=slow.next;
        }

        ListNode prev=null;
        ListNode curr=slow.next;
        while(curr!=null) {
            ListNode temp = curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }


        slow.next=null;

        ListNode l1 = head;
        ListNode l2 = prev;

        while(l1!=null && l2!=null) {
            ListNode temp1;
            ListNode temp2;

            temp1=l1.next;
            temp2=l2.next;

            l1.next=l2;
            l2.next=temp1;

            l1=temp1;
            l2=temp2;
        }
    }
}
