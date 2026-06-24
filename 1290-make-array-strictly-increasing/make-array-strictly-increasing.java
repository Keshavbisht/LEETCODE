class Solution {
    HashMap<Integer, Integer>[] dp;
    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        Arrays.sort(arr2);
        dp = new HashMap[arr1.length];

        for(int i = 0; i< arr1.length; i++){
            dp[i] = new HashMap<>();
        }
        int ans =helper(0, -1, arr1, arr2);
        
        return ( ans != Integer.MAX_VALUE) ? ans : -1;
    }

    public int helper(int ind, int prev, int[] arr1, int[] arr2){
        if(ind>= arr1.length){
            return 0;
        }

        if(dp[ind].containsKey(prev)) return dp[ind].get(prev);

        int take = Integer.MAX_VALUE;
        int notTake = Integer.MAX_VALUE;

        if(prev == -1 || arr1[ind] > prev){
            notTake = helper(ind+1, arr1[ind], arr1, arr2);
        }
        
        
        int upper = UpperBound(prev, arr2);
        // System.out.println(ind +" "+ upper);
        if(upper != -1 && upper < arr2.length){
            take = helper(ind+1, arr2[upper], arr1, arr2);
        }

            // arr1[ind] = upper;
        if(take != Integer.MAX_VALUE ){
            take +=1;
        }
        
        dp[ind].put(prev, Math.min(take, notTake));
        return Math.min(take, notTake);
    }

    public int UpperBound(int val, int[] nums ){
        int l = 0;
        int h = nums.length;
        while(l < h){
            int mid = l + (h-l)/2;
            if(nums[mid] <= val){
                l = mid+1;
            }
            else{
                h = mid;
            }
        }
        // if(l > h || h<l) return -1;
        return l;
    }
}