class Solution {
    public int[] frequencySort(int[] nums) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int i= 0; i< nums.length; i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i], 1);
            }
            else{
                map.put(nums[i], map.get(nums[i])+1 );
            }
        }
        List<Map.Entry<Integer, Integer>> arr = new ArrayList<>(map.entrySet());
        arr.sort((a, b) -> {
            if (!a.getValue().equals(b.getValue())) {
                return a.getValue() - b.getValue(); 
            } else {
                return b.getKey() - a.getKey(); 
            }
        });
        for(Map.Entry<Integer, Integer> entry: arr){
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
        int i = 0;
        for(Map.Entry<Integer, Integer> entry: arr){
            int a  = entry.getKey();
            int b = entry.getValue();
            while(b-- >0){
                nums[i] = a;
                i++;
            }
        }
        return nums;
    }
}