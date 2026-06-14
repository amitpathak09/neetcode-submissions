class Node {
    int key;
    int value;
    Node prev;
    Node next;

    Node(int key,int value) {
        this.key=key;
        this.value=value;
        this.prev=null;
        this.next=null;
    }
}

class LRUCache {
    private int capacity;
    private Map<Integer, Node> cache;
    private Node lru;
    private Node mru;

    public LRUCache(int capacity) {
        //System.out.println("Capacity: "+String.valueOf(capacity));
        this.capacity=capacity;
        cache = new HashMap<>();
        this.lru = new Node(0,0);
        this.mru = new Node(0,0);
        this.mru.next = this.lru;
        this.lru.prev = this.mru;
        
    }
    
    public int get(int key) {
        //System.out.println(String.valueOf(key)+" "+String.valueOf(this.cache.keySet()));
        if(cache.containsKey(key)) {
            Node n = cache.get(key);
            remove(n);
            updateMRU(n);
            return n.value;
        } else {
            return -1;
        }
        
    }

    private void remove(Node n) {
        Node prev = n.prev;
        Node next = n.next;
        prev.next=next;
        next.prev=prev;
    }

    private void updateMRU(Node n) {
        Node temp = this.mru.next;
        this.mru.next=n;
        n.prev=mru;
        n.next=temp;
        temp.prev=n;
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)) {
            remove(cache.get(key));
            // cache.remove(key);
        }
        Node n = new Node(key,value);
        updateMRU(n);
        cache.put(key,n);
        //System.out.println("Key: "+String.valueOf(key)+", cache size: "+String.valueOf(cache.size()));
        removeLRUIfRequired();
    }

    private void removeLRUIfRequired() {
        if(cache.size()>this.capacity) {
            //System.out.println("About to delete LRU");
            Node n = this.lru.prev;
            Node prev = n.prev;
            prev.next=this.lru;
            this.lru.prev=prev;

            int key = n.key;
            cache.remove(key);
        }
    }
}
