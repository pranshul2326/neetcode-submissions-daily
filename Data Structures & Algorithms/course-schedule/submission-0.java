class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph= new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0;i<prerequisites.length;i++){
            int a = prerequisites[i][0];
            int b = prerequisites[i][1];
            graph.get(b).add(a);
        }

        int[] visited = new int[numCourses];

        for(int i=0;i<numCourses;i++){
            if(visited[i]==0){
                if(runDFS(numCourses,graph,i, visited)){
                    return false;
                }
            }
        }
        return true;
        
    }

    boolean runDFS(int n,List<List<Integer>> graph, int idx,int[] visited){

         if (visited[idx] == 1) {
        return true;
    }

    if (visited[idx] == 2) {
        return false;
    }


        visited[idx] = 1;
        for(int val : graph.get(idx)){
            if(runDFS(n,graph,val,visited)){
                return true;
            }
        }
        visited[idx] =2;
        return false;
        
    }
}
