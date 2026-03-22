class Solution {
    public boolean uniformArray(int[] nums1) {
        int odd = 0;
        int even = 0;

        for(int i = 0; i< nums1.length; i++){
            if(nums1[i] % 2 == 0){
                even+=1;
            }
            else{
                odd+=1;
            }
        }
        return true;
        // if(even==odd) return true;
        // if(even >=1 && odd == 0) return true;
        // if(odd >=1 && even == 0) return true;
        // return false;
        
    }
}