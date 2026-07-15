/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node,Integer> map1 = new HashMap<>();
        Map<Integer,Node> map2 = new HashMap<>();
        if(head==null) return null;
        Node newHead = new Node(head.val);

        int i = 1;
        map1.put(head,i);
        map2.put(i,newHead);

        Node curr = head;
        Node curr2 = newHead;

        while(curr!=null) {
            if(curr.next!=null) {
                curr = curr.next;
                i++;
                map1.put(curr,i);
                Node temp = new Node(curr.val);
                curr2.next = temp;
                curr2 = curr2.next;
                map2.put(i,curr2);
            } else {
                curr = curr.next;
            }
        }

        curr=head;
        curr2=newHead;
        while(curr!=null) {
            if(curr.random==null) {
                curr2.random = null;
            } else {
                curr2.random = map2.get(map1.get(curr.random));
            }
            curr = curr.next;
            curr2 = curr2.next;
        }
        return newHead;
    }
}
