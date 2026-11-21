class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length!=n-1){
            return false;
        }

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

        boolean[] visited = new  boolean[n];
        
        if(isCyclic(graph,0,visited,-1))
        {
            return false;
        }
        int counter = 0;
        for(boolean val : visited){
            if(val) counter++;
        }

        if(counter!=n){
            return false;
        }

        return true;

    }

    boolean isCyclic(List<List<Integer>> graph, int idx, boolean[] visited,int parent){

        visited[idx] = true;
        for(int nbr : graph.get(idx)){
            if(nbr == parent){
                continue;
            }

            if(visited[nbr]){
                return true;
            }
            if(isCyclic(graph,nbr,visited,idx)){
                return true;
            }

        }

        return false;




    }
}
