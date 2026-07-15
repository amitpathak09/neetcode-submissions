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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode curr1 = l1;
        ListNode curr2 = l2;
        int carry = 0;

        ListNode head = null;
        ListNode prev = null;

        while(curr1!=null || curr2!=null) {
            int temp = 0;
            if(curr1!=null && curr2!=null) {
                temp = curr1.val + curr2.val + carry;
                if(temp/10!=0) {
                    carry = temp/10;
                } else {
                    carry = 0;
                }
                ListNode l = new ListNode(temp%10);
                if(head==null) {
                    head = l;
                    prev = l;
                } else {
                    prev.next = l;
                    prev = l;
                }
                curr1=curr1.next;
                curr2=curr2.next;
            } else if(curr1!=null) {
                temp = curr1.val + carry;
                if(temp/10!=0) {
                    carry = temp/10;
                } else {
                    carry = 0;
                }
                ListNode l = new ListNode(temp%10);
                if(head==null) {
                    head = l;
                    prev = l;
                } else {
                    prev.next = l;
                    prev = l;
                }
                curr1=curr1.next;
            } else {
                temp = curr2.val + carry;
                if(temp/10!=0) {
                    carry = temp/10;
                } else {
                    carry = 0;
                }
                ListNode l = new ListNode(temp%10);
                if(head==null) {
                    head = l;
                    prev = l;
                } else {
                    prev.next = l;
                    prev = l;
                }
                curr2=curr2.next;
            }
        }
        if(carry!=0) {
            ListNode l = new ListNode(carry);
            prev.next=l;
        }

        return head;
    }
}
