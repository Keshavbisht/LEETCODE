import java.util.*;

class Solution {
    public int[] avoidFlood(int[] rains) {
        HashMap<Integer, Integer> map = new HashMap<>(); // lake -> last rain day
        HashSet<Integer> set = new HashSet<>();          // lakes currently full
        ArrayList<Integer> zero = new ArrayList<>();     // indexes of dry days
        int[] ans = new int[rains.length];
        Arrays.fill(ans, -1);

        for (int i = 0; i < rains.length; i++) {

            // if it’s a dry day, just store the index
            if (rains[i] == 0) {
                zero.add(i);
                continue;
            }

            // if lake already full → we need to find a zero day after last rain
            if (set.contains(rains[i])) {
                boolean done = false;
                for (int j = 0; j < zero.size(); j++) {
                    if (zero.get(j) > map.get(rains[i])) {
                        ans[zero.get(j)] = rains[i]; // dry this lake on that day
                        zero.remove(j);
                        done = true;
                        break;
                    }
                }

                // if we never found a valid zero day → flood
                if (!done) {
                    return new int[0];
                }
            }

            // mark the lake as filled and store its latest rain day
            set.add(rains[i]);
            map.put(rains[i], i);
        }

        // fill remaining zero days with any lake number (say 1)
        for (int idx : zero) {
            ans[idx] = 1;
        }

        return ans;
    }
}
