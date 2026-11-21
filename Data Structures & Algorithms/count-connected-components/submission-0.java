class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0;i<edges.length;i++){
            int a = edges[i][0];
            int b = edges[i][1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        boolean[] visited = new boolean[n];
        int count = 0;
        for(int i=0;i<n;i++){
            if(visited[i]==false){
                makeItVisited(graph,i,visited);
                count++;
            }
        }
        return count;
    }
    void makeItVisited(List<List<Integer>> graph,int idx, boolean[] visited){
        visited[idx] = true;
        for(int nbr: graph.get(idx)){
            if(visited[nbr]){
                continue;
            }
            makeItVisited(graph,nbr, visited);
        }
    }
}
