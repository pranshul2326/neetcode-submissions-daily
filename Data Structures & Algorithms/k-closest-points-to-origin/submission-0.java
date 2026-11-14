class Solution {
    class Node{
        int x;
        int y;
        int dist;
        Node(int x, int y,int dist){
            this.x = x;
            this.y = y;
            this.dist = dist;

        }

    }
    public int[][] kClosest(int[][] points, int k) {
        int len = points.length;
        // HashMap<Integer, Node> map = new HashMap<>();
        PriorityQueue<Node> q = new PriorityQueue<>((a,b)->(a.dist-b.dist));
        for(int i=0;i<len;i++){
            int x = points[i][0];
            int y = points[i][1];

            int dist = (x*x+y*y)^(1/2);
            Node node = new Node(x,y,dist);
            q.add(node);
        }

        int[][] ans = new int[k][2];
        for(int i = 0;i<k;i++){
            Node v = q.poll();
            ans[i][0]=v.x;
            ans[i][1]=v.y;
        }

        return ans;

    }
}
