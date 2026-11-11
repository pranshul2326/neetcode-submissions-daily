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

        // Step 1: Create HashMap
        HashMap<Node,Node> map= new HashMap<>();

        // Step 2: Create copies of all nodes
        Node curr = head;
        while(curr!=null){
            map.put(curr, new Node(curr.val));
            curr = curr.next;
        }
        // Step 3: Connect next and random pointers
         curr = head;

        while(curr!=null){
            Node copy = map.get(curr);

            copy.next = map.get(curr.next);
            copy.random = map.get(curr.random);
            curr = curr.next;
        }

        // Step 4: Return copied head

        return map.get(head);


   
    }
}
