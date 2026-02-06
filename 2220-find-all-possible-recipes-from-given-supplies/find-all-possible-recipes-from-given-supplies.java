class Solution {
    HashSet<String> set;
    // HashSet<String> recipesCheck;
    HashMap<String, List<String>> map;
    HashMap<String, Integer> state;
    // boolean vis[];
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        set = new HashSet<>();
        map = new HashMap<>();
        state = new HashMap<>();
        List<String> ans = new ArrayList<>();
        for(int i = 0; i< supplies.length; i++){
            set.add(supplies[i]);
        }
        for(int i = 0; i< recipes.length; i++){
            map.put(recipes[i], ingredients.get(i));
        }
        for(int i = 0; i< recipes.length; i++){
            if(dfs(recipes[i])){
                set.add(recipes[i]);
                ans.add(recipes[i]);
            }
        }
        return ans;

    }
    public boolean dfs(String check){
        if(set.contains(check)) return true;
        
        if(!map.containsKey(check)) return false;

        if(state.containsKey(check)){
            if(state.get(check) == 1) return false;
            if(state.get(check) == 2) return true;
            
        }
        state.put(check, 1);

        List<String> temp = map.get(check);

        for(int i = 0; i< temp.size(); i++){
            String curr = temp.get(i);
            if(!dfs(curr)) return false;
        }
        state.put(check, 2);
        return true;
    }
}