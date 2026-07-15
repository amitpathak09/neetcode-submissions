class ListNode {
    public int key;
    public int val;
    public ListNode(int key, int val) {
        this.key = key;
        this.val = val;
        this.front = null;
        this.back = null;
    }
    public ListNode front;
    public ListNode back;
}

class LRUCache {
    int capacity;
    ListNode cFront;
    ListNode cBack;
    Map<Integer, ListNode> cache;

    public LRUCache(int capacity) {
        this.cache = new HashMap<>();
        this.capacity = capacity;
        this.cFront = null;
        this.cBack = null;
    }
    
    public int get(int key) {
        if(cache.containsKey(key)) {
            ListNode l = cache.get(key);
            removeNode(l);
            updateFront(l);
            return l.val;
        } else {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)) {
            ListNode l = cache.get(key);
            l.val = value;
            removeNode(l);
            updateFront(l);
        } else {
            ListNode l = new ListNode(key, value);
            if(cache.size()==0) {
                cBack = l;
            }
            cache.put(key, l);
            updateFront(l);
        }
        while(cache.size()>capacity) {
            evictLRU();
        }
    }

    private void evictLRU() {
        ListNode f = cBack.front;
        if(f!=null) {
            f.back=null;
        } else {
            cFront = null;
        }
        cache.remove(cBack.key);
        cBack = f;

    }

    private void updateFront(ListNode l) {
        l.front = null;
        l.back = cFront;
        if(cFront!=null) {
            cFront.front = l;
        }
        cFront = l;

        if(cBack==null) {
            cBack = l;
        }
    }

    private void removeNode(ListNode l) {
        ListNode f = l.front;
        ListNode b = l.back;
        if(f!=null) {
            f.back = b;
        } else {
            cFront = b;
        }
        if(b!=null) {
            b.front = f;
        } else {
            cBack = f;
        }
    }
}
