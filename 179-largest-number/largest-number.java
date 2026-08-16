class Solution {
    public String largestNumber(int[] arr) {
        StringBuilder sb = new StringBuilder();
        String[] nums = new String[arr.length];

        for(int i = 0; i< arr.length; i++){
            nums[i] = String.valueOf(arr[i]);
        }
        Arrays.sort(nums, (a,b) -> (b+a).compareTo(a+b));
        if(nums[0].equals("0")) return "0";
        for(int i = 0; i < nums.length; i++){
            sb.append(nums[i]);
        }

        return sb.toString();
    }
}