class Solution {
    public int leastInterval(char[] tasks, int n) {
        // int maxi = Integer.MIN_VALUE;
        // if(n==1) return tasks.length;
        int[] arr = new int[28];
        int unique = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i< tasks.length; i++){
            int a = tasks[i] - 'A';
            int temp = 0;
            if(arr[a] == 0){
                arr[a] = unique+1;
                temp = arr[a];
            }
            else{
                arr[a] = arr[a] +n+1;
                temp = arr[a];
            } 
            pq.add(temp);
            // maxi = Math.max(maxi, arr[a]);

        }
        int ans;
        int ind = 1;
        while(!pq.isEmpty()){
            int curr = pq.peek();
            // System.out.println(curr);
            if(curr == ind || curr < ind){
                pq.remove();
            }
            ind++;
        }
        return ind-1;
    }
}