# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if head is None:
            return
        if head.next is None:
            return head
        prevNode = None
        currNode = head
        
        while(head is not None):
            head = head.next
            currNode.next = prevNode
            prevNode = currNode
            currNode = head
        
        return prevNode

        

        