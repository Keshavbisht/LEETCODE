class Solution {
    public List<String> summaryRanges(int[] nums) {
        int pnt1 = 0;
        int pnt2 = -1;
        List<String> ans = new ArrayList<>();

        int n = nums.length;
        while(pnt2< nums.length-1){
            pnt2++;

            if((pnt2<n-1 && (nums[pnt2] != nums[pnt2+1]-1)) || pnt2 ==n-1 ){
                StringBuilder sb = new StringBuilder();
                if(pnt1==pnt2){
                    sb.append(nums[pnt1]);
                    ans.add(sb.toString());
                }
                else{
                    sb.append(nums[pnt1]);
                    sb.append("->");
                    sb.append(nums[pnt2]);
                    ans.add(sb.toString());
                    
                }
                pnt1 = pnt2+1;
            } 
        }
        for(int i = 0; i< ans.size(); i++){
            System.out.println(ans.get(i));
        }
        return ans;
    }
}