class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i< arr.length; i++){
            if(!map.containsKey(arr[i])){
                map.put(arr[i], 1);
            }
            else{
                map.put(arr[i], map.get(arr[i]) +1);
            }
        }
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            int a = entry.getValue();
            if(set.contains(a)) return false;
            set.add(a);
        }
        return true;

    }
}