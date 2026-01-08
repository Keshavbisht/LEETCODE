class Solution {
    public int minDeletions(String s) {
        int maxi = 1;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i< s.length(); i++){
            char temp = s.charAt(i);
            if(map.containsKey(temp)){
                map.put(temp, map.get(temp)+1);
                maxi = Math.max(maxi, map.get(temp));
            }
            else{
                map.put(temp, 1);
            }
        }
        int ans = 0;
        int[] arr = new int[maxi+1];
        Arrays.fill(arr, 0);
        for(Map.Entry<Character, Integer> entry: map.entrySet()){
            int temp = entry.getValue();
            arr[temp]++;
        }
        ArrayList<Integer> flag = new ArrayList<>();
        for(int i = 0; i< maxi+1; i++){
            int ind = i;
            if(arr[i] == 0){
                flag.add(i);
            }
            else if(arr[i] > 1){
                int count = arr[i];
                while(count-- >1){
                    if(flag.size() != 0){
                        ans = ans + (i - flag.get(flag.size()-1));
                        flag.remove(flag.size()-1);
                        continue;
                    }
                    ans = ans + i;  
                }
            }
        }
        return ans;
    }
}