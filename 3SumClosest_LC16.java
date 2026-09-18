class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if (ans == Integer.MAX_VALUE || Math.abs(sum - target) < Math.abs(ans - target)) {
                    ans = sum;
                }
                if (sum == target)
                    break;
                else if (sum < target)
                    start++;
                else end--;
            }
        }
        return ans;
    }
}
// simple 3 sum approach , fix the first index , find the next 2 indexes ahead , and check if their sum - target ka diff < ans-target ka diff , then keep updating by using simple 2 pointer approach 
// t.c = N^2
