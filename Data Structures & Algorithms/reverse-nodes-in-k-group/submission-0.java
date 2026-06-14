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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr=head;
        ListNode currHead = head;
        ListNode tail=head;

        boolean headUpdated = false;


        while(curr!=null) {
            ListNode start = curr;
            for(int i=1; i<=k; i++) {
                if(curr==null) {
                    return currHead;
                }
                curr=curr.next;
            }
            
            ListNode prev = null;
            ListNode curr2 = start;
            while(curr2!=curr) {
                ListNode temp = curr2.next;
                curr2.next=prev;
                prev=curr2;
                curr2=temp;
            }
            if(!headUpdated) {
                currHead = prev;
                headUpdated=true;
            } else {
                tail.next=prev;
            }
            start.next=curr;
            tail=start;
        }

        return currHead;


    }
}
