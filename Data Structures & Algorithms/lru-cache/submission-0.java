class LRUCache {
    class Node{
        int key;
        int val;
        Node prev;
        Node next;
        Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }
    HashMap<Integer, Node> map;
    int capacity;
    Node head;
    Node tail;
    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
        head = new Node(-1,-1);
        tail = new Node(-1,-1);

         // Connect head and tail
         head.next = tail;
         tail.prev = head;

    }
     // Remove a node from its current position
    private void remove(Node node) {
        // Connect node.prev and node.next
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // Insert node immediately after head (MRU position)
    private void insert(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    // Move an existing node to MRU position
    private void makeRecentlyUsed(Node node) {
        remove(node);
        insert(node);
    }

    public int get(int key) {

        // 1. Check if key exists in map
        if(map.containsKey(key)){
            Node node = map.get(key);
            makeRecentlyUsed(node);
            return node.val;
        }else{
            return -1;
        }

        // 2. If not found, return -1

        // 3. Get the node

        // 4. Move node to MRU position

        // 5. Return node.value

        // return -1;
    }

    public void put(int key, int value) {

        // 1. Check if key already exists
        if(map.containsKey(key)){ 
            Node node = map.get(key);
            node.val = value;  // Update existing value
            makeRecentlyUsed(map.get(key));
        }else{
            Node newNode = new Node(key, value);
            map.put(key, newNode);  // Add to HashMap
            insert(newNode);       // Add to MRU position
        }

        if(map.size()>capacity){
            Node lru = tail.prev;

        // Remove from linked list
        remove(lru);

        // Remove from HashMap
        map.remove(lru.key);


        }

        // 2. If exists:
        //    Update value
        //    Move node to MRU position

        // 3. If it doesn't exist:
        //    Create a new node
        //    Add it to map
        //    Insert it at MRU position

        // 4. If capacity exceeded:
        //    Remove LRU node (node before tail)
        //    Remove its key from map
    }
}
