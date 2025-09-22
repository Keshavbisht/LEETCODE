class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        Arrays.sort(arr);
        long mod = (long)1e9 + 7;

        HashMap<Integer, Long> dp = new HashMap<>();
        long ans = 0;

        for (int i = 0; i < arr.length; i++) {
            long temp = 1; 

            for (int j = 0; j < i; j++) {
                if (arr[i] % arr[j] == 0) {
                    int a = arr[i] / arr[j];
                    if (dp.containsKey(a)) {
                        temp = (temp + dp.get(arr[j]) * dp.get(a)) % mod;
                    }
                }
            }

            dp.put(arr[i], temp);
            ans = (ans + temp) % mod;
        }

        return (int) ans;
    }
}
