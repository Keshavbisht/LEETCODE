class Solution {
    public int[] findOrder(int n, int[][] arr) {
        // BFS
        int[] ans =new int[n];
        Queue<Integer> q = new LinkedList<>();
        int[] inorder = new int[n];

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i<n; i++){
            adj.add(new ArrayList<>());
        } 
        for(int i = 0; i< arr.length; i++){
            int u = arr[i][1];
            int v = arr[i][0];

            adj.get(u).add(v);
            inorder[v]++;
        }

        for(int i = 0; i< n; i++){
            if(inorder[i] == 0){
                q.add(i);
            }
        }
        int count = -1;
        while(!q.isEmpty()){
            int curr = q.remove();
            count++;
            ans[count] = curr;

            for(int i = 0; i< adj.get(curr).size(); i++){
                int temp = adj.get(curr).get(i);
                inorder[temp]--;
                if(inorder[temp] == 0){
                    q.add(temp);
                }

            }
        }
        return (count == n-1) ? ans : new int[]{};
    }
}