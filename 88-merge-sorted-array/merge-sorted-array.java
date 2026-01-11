class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int pnt1 = m-1;
        int pnt2 = n-1; 
        int pnt3 = nums1.length-1;
        while(pnt1>=0 && pnt2 >= 0){
            if(nums1[pnt1] > nums2[pnt2]){
                nums1[pnt3] = nums1[pnt1];
                // nums1[pnt1] = nums2[pnt2];
               
                // pnt2--;
                pnt1--;
            }
            else{
                nums1[pnt3] = nums2[pnt2];
                // nums1[pnt1] = nums2[pnt2]];
                
                // pnt2--;
                pnt2--;
            }
            pnt3--;
            
        }
        while(pnt2>=0){
                nums1[pnt3]=nums2[pnt2];
                pnt3--;
                pnt2--;
            }

    }
}