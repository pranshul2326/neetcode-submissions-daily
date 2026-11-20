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
    public Node cloneGraph(Node node) {
        if(node == null){
            return null;
        }

        HashMap<Node, Node> map = new HashMap<>();
        Node root = new Node(node.val);
        map.put(node, root);
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        while(queue.size()>0){
            Node temp = queue.poll();
            for(Node nbr :  temp.neighbors){
                if(!map.containsKey(nbr)){
                    map.put(nbr, new Node(nbr.val));
                    queue.offer(nbr);
                }

                map.get(temp).neighbors.add(map.get(nbr));

            }

        }
        return map.get(node);
        
        
    }
}