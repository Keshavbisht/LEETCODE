class Solution {
    public int beautySum(String s) {
        int ans = 0;
        for(int i = 0; i< s.length(); i++){
            int[] arr = new int[26+1];
            
            for(int j = i; j<s.length(); j++){
                int mini = Integer.MAX_VALUE;
                int maxi = 0;
                arr[s.charAt(j) - 'a'] = arr[s.charAt(j) - 'a']+1;
                for(int k = 0; k<arr.length;k++){
                    if(arr[k] > 0){
                        mini = Math.min(mini,arr[k]);
                    }
                    maxi = Math.max(maxi, arr[k]);
                }
                
                if(maxi - mini >0){
                    ans = ans+(maxi - mini);
                }
            }
        }
        return ans;
        
    }
}