class Solution {
    public long repairCars(int[] ranks, int cars) {
        long low = 1;
        
        long maxRank = 0;
        for (int rank : ranks) {
            maxRank = Math.max(maxRank, rank);
        }
        long high = maxRank * (long)cars * cars;
        
        long ans = high;
        
        while (low <= high) {
            long mid = low + (high - low) / 2;
            
            if (canRepairInTime(ranks, cars, mid)) {
                ans = mid;
                high = mid - 1;  
            } else {
                low = mid + 1;   
            }
        }
        
        return ans;
    }
    
    private boolean canRepairInTime(int[] ranks, int cars, long time) {
        long totalCars = 0;
        
        for (int rank : ranks) {
            
            long maxCars = (long)Math.sqrt(time / rank);
            totalCars += maxCars;
            
            if (totalCars >= cars) {
                return true;  
            }
        }
        
        return totalCars >= cars;
    }
}