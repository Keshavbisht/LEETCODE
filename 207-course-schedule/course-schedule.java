class Solution {
    int[] indegree;
    boolean[] vis;
    public boolean canFinish(int numCourses, int[][] arr) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        indegree = new int[numCourses];
        vis = new boolean[numCourses];

        for(int i = 0; i< numCourses; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i< arr.length; i++){
            adj.get(arr[i][1]).add(arr[i][0]);
            indegree[arr[i][0]]++;
        }
        
        // CALLING DFS FOR CYCLE CHECK
        // for(int i= 0; i< numCourses; i++){
        //     boolean[] flag = new boolean[numCourses];
        //     if(!vis[i]){
        //         if(dfs(i, adj, flag)) return false;
        //     }
        // }

        // CALLING BFS FOR CYCLE CHECK
        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i< numCourses; i++){
            if(indegree[i] == 0){
                q.add(i);
                count++;
            }
        }

        while(!q.isEmpty()){
            int curr = q.remove();
            
            
            for(int i = 0; i< adj.get(curr).size(); i++){
                // if(adj.get(curr).size() == 0) break;
                int temp = adj.get(curr).get(i);
                indegree[temp]--;
                if(indegree[temp] == 0){
                    q.add(temp);
                    count++;
                }
            }
        }
        System.out.println(count);
        return (count == numCourses);


    }
    public boolean dfs(int ind, ArrayList<ArrayList<Integer>> adj, boolean[] flag){
        if(flag[ind] == true) return true;
        vis[ind] = true;
        flag[ind] = true;

        for(int i=0; i< adj.get(ind).size(); i++){
            int temp = adj.get(ind).get(i);
            
            if(dfs(temp, adj, flag)) return true;
            
        }
        flag[ind]=false;
        return false;
    }
}