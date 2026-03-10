class Solution {
    public int maximumEnergy(int[] energy, int k) {
        int maxi = Integer.MIN_VALUE;
        int n = energy.length;
        for(int i = 0; i< k; i++){
            maxi = Math.max(maxi, helper(n-i-1, energy, k));
        }
        return maxi;
    }
    public int helper(int ind, int[] energy, int k){
        if(ind < 0) return 0;

        if(ind == 0) return energy[0];
        // if(ind == 1) return energy[1];

        int a = helper(ind-k, energy, k);
        return Math.max(a+energy[ind], energy[ind]);
        
        // return a + energy[ind];
    }
}