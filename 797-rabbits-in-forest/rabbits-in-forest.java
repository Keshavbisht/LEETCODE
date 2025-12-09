class Solution {
    public int numRabbits(int[] answers) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i< answers.length; i++){
            if(!map.containsKey(answers[i])){
                map.put(answers[i], 1);
                continue;
            }
            map.put(answers[i], map.get(answers[i]) +1);
        }
        System.out.println(3%11);
        int ans = 0;
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            boolean z = false;
            int a = entry.getKey() +1;
            // if(entry.getValue()%a < a){
            //     ans += a;
            // }
            // else{
            ans = ans + ((entry.getValue() + a-1)/a)*a; 
            // }
            
        }
        return ans;








    }
}