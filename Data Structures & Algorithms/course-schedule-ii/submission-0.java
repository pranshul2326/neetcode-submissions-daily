class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph= new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0;i<prerequisites.length;i++){
            int a = prerequisites[i][0];
            int b = prerequisites[i][1];
            graph.get(b).add(a);
        }

        List<Integer> result = new ArrayList<>();
        int[] visited = new int[numCourses];

        for(int i=0;i<numCourses;i++){
            if(visited[i]==0){
                if(runDFS(numCourses,graph,i, visited,result)){
                    return new int[0];
                }
            }
        }
        // int[] ans = new int[result.size()];
        // if(result.size()==0){
        //     return new int[0];
        // }else{
            
        //     int x = result.size()-1;
        //     while(x-->0){
        //         ans[x] = result.remove(result.size()-1);
        //     }
        // }

        Collections.reverse(result);

        int[] ans = new int[numCourses];

        for(int i = 0; i < numCourses; i++){
            ans[i] = result.get(i);
        }

        return ans;

}


    boolean runDFS(int n,List<List<Integer>> graph, int idx,int[] visited,List<Integer> result){

         if (visited[idx] == 1) {
        return true;
    }

    if (visited[idx] == 2) {
        return false;
    }


        visited[idx] = 1;
        for(int val : graph.get(idx)){
            if(runDFS(n,graph,val,visited, result)){
                return true;
            }
        }
        visited[idx] =2;
        result.add(idx);
        return false;
        
    }
}

