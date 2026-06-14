class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = null;
        ListNode curr = head;
        ListNode nex = null;

        while (curr != null) {
            nex = curr.next;   // save next node
            curr.next = prev;  // reverse link
            prev = curr;       // move prev forward
            curr = nex;        // move curr forward
        }

        return prev;  // new head
    }
}
