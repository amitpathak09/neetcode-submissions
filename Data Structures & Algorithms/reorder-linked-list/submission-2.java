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

 //0->1->2->3->4->5->6
 //0->1->2 3<-4<-5<-6
 //0 1 2.  5 4 3

class Solution {
    public void reorderList(ListNode head) {
        int n=0;
        ListNode curr = head;
        while(curr!=null) {
            n++;
            curr=curr.next;
        }

        int mid = n%2==0?n/2:n/2+1;

        curr=head;
        int c = 1;
        while(c!=mid) {
            curr = curr.next;
            c++;
        }

        ListNode head2 = reverse(curr.next);
        curr.next=null;
        ListNode head1 = head;
        merge(head1, head2);
    }

    ListNode reverse(ListNode head) {
        if(head==null) return head;
        ListNode prev = head;
        ListNode curr = head.next;
        head.next=null;
        while(curr!=null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

    void merge(ListNode head1, ListNode head2) {
        ListNode curr1 = head1;
        ListNode curr2 = head2;
        while(curr1!=null && curr2!=null) {
            ListNode temp1 = curr1.next;
            curr1.next = curr2;
            ListNode temp2 = curr2.next;
            if(temp1!=null) {
                curr2.next = temp1;
            } else {
                break;
            }
            curr1 = temp1;
            curr2 = temp2;
        }
    }
}
