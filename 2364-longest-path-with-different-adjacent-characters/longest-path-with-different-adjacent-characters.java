class Solution {
    int ans = 0;
    public int longestPath(int[] parent, String s) {
        List<List<Integer>> adj = new ArrayList<>();
        int n = s.length();

        for(int i = 0; i< n; i++){
            adj.add(new ArrayList<Integer>());
        }

        for(int i = 0; i<parent.length; i++){
            if(parent[i] != -1){
                adj.get(parent[i]).add(i);
            }
        }
        int currSum = 1;
        List<Integer> check = new ArrayList<>();
        // for(int i = 0; i< adj.get(0).size(); i++){
        //     check.add(dfs(adj.get(0).get(i), s.charAt(0), s, adj));
        // }
        // Collections.sort(check);
        // Collections.reverse(check);
        // for(int i = 0; i< 2; i++){
        //     if(i >= check.size()) break;
        //     currSum += check.get(i);
        // }
        // ans = Math.max(ans, currSum);
        dfs(0, s.charAt(0), s, adj);
        
        return ans;
    }
    public int dfs(int ind, char par, String s, List<List<Integer>> adj){
        List<Integer> check = new ArrayList<>();
        check.add(0);
        char currChar = s.charAt(ind);
        // if (currChar == par) return 0;
        int currSum = 1;
        for(int i = 0; i< adj.get(ind).size(); i++){
            int temp = adj.get(ind).get(i);
            int check2 = dfs(temp, currChar, s, adj);
            if(s.charAt(temp) == currChar) continue;
            check.add(check2);
        }

        Collections.sort(check);
        Collections.reverse(check);
        for(int i = 0; i< 2; i++){
            if(i >= check.size()) break;
            currSum += check.get(i);
        }
        ans = Math.max(ans, currSum);
        return check.get(0) +1;
    }
}