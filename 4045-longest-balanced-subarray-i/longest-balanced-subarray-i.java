class Solution {
    public int longestBalanced(int[] nums) {
        int maxi = 0;
        
        for(int i = 0; i < nums.length; i++){
            Set<Integer> oddSet = new HashSet<>();
            Set<Integer> evenSet = new HashSet<>();
            int CountOdd = 0;
            int CountEven = 0;
            
            for(int j = i; j < nums.length; j++){
                if(nums[j] % 2 == 0){
                    if(!evenSet.contains(nums[j])){
                        CountEven++;
                        evenSet.add(nums[j]);
                    }
                } 
                else {
                    if(!oddSet.contains(nums[j])){
                        CountOdd++;
                        oddSet.add(nums[j]);
                    }
                }
                
                if(CountOdd == CountEven){
                    maxi = Math.max(maxi, j-i +1);
                }
            }
        }
        
        return maxi;
    }
}