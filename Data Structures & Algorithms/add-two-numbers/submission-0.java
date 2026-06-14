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

        //processing l1
        int pow = 0;
        ListNode curr = l1;
        int fn = 0;
        while(curr!=null) {
            fn+=curr.val* Math.pow(10,pow);
            pow++;
            curr=curr.next;
        }
        
        //processing l2

        pow = 0;
        curr = l2;
        int sn = 0;
        while(curr!=null) {
            sn+=curr.val* Math.pow(10,pow);
            pow++;
            curr=curr.next;
        }

        int sum=fn+sn;

        //Creating a listNode
        char[] carr = String.valueOf(sum).toCharArray();
        ListNode head = null;
        ListNode prev = null;

        for(int i=carr.length-1 ; i>=0 ; i--) {
            if(i==carr.length-1) {
                head = new ListNode(carr[i]-'0');
                prev = head;
                continue;
            }
            ListNode node = new ListNode(carr[i]-'0');

            prev.next = node;
            prev = node;
        }
        prev.next=null;
        return head;
        
    }

}
