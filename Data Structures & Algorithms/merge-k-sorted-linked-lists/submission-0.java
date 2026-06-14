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
    public ListNode mergeKLists(ListNode[] lists) {
        int k = lists.length;
        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>((a,b)->Integer.compare(a.val,b.val));
        for(ListNode node: lists) {
            if(node!=null) {
                priorityQueue.offer(node);
            }
        }

        while(!priorityQueue.isEmpty()) {
            ListNode min = priorityQueue.poll();
            curr.next=min;
            curr=curr.next;
            if(min.next!=null) {
                priorityQueue.offer(min.next);
            }
        }
        return dummy.next;
    }
}
