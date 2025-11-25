class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] vis = new boolean[rooms.size()];
        Arrays.fill(vis, false);

        Queue<List<Integer>> q = new LinkedList<>();
        q.add(rooms.get(0));
        
        while(!q.isEmpty()){
            List<Integer> temp = q.remove();
            for(int i = 0; i< temp.size(); i++){
                if(vis[temp.get(i)] == false){
                    vis[temp.get(i)] = true;
                    q.add(rooms.get(temp.get(i)));
                }
            }
        } 
        for(int i = 1; i< vis.length; i++){
            if(vis[i] == false) return false;
        }
        return true;
    }
}