class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int total = 0;
        int[] prefix = new int[customers.length];
        int tempPrefix = 0;

        int ans = 0;
        for(int i = 0; i< customers.length; i++){
            if(grumpy[i] == 0){
                total += customers[i];
            }
            else{   
                tempPrefix += customers[i];
                   
            }
            prefix[i] = tempPrefix;         
        }

        for(int i = 0; i< prefix.length; i++){
            System.out.print(prefix[i] + " ");
        }
        int pnt2 = -1;
        for(int pnt1 = 0; pnt1< customers.length; pnt1++){
            if(grumpy[pnt1] == 1 && pnt1>0){
                int temp = 0;
                if(pnt1+ minutes -1 >= customers.length){
                    temp = prefix[customers.length-1] - prefix[pnt1-1];
                }
                else{
                    temp = prefix[pnt1 + minutes-1] - prefix[pnt1-1];
                }
                ans = Math.max(ans, total + temp);
            }
            else if(grumpy[pnt1] == 1 && pnt1==0) {
                int temp = 0;
                if(pnt1+ minutes >= customers.length){
                    temp = prefix[customers.length-1];
                }
                else{
                    temp = prefix[pnt1 + minutes-1] - 0;
                }
                ans = Math.max(ans, total + temp);
            }
        }
        ans = Math.max(ans, total);
        return ans;

        
    }
}