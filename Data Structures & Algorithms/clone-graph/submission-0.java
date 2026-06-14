/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    HashMap<Node, Node> visited = new HashMap<>();

    public Node cloneGraph(Node node) {
        if(node==null) return null;

        if(visited.containsKey(node)) {
            return visited.get(node);
        }

        ArrayList<Node> cloneNeighbors = new ArrayList<>();
        Node cloneNode = new Node(node.val, cloneNeighbors);
        
        visited.put(node, cloneNode);

        for(Node n: node.neighbors) {
            cloneNeighbors.add(cloneGraph(n));
        }

        return cloneNode;
    }
}