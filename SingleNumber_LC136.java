class Solution {
    public int singleNumber(int[] nums) {
        // // Using HashSet
        // HashSet<Integer> set = new HashSet<>();
        // for(int i=0;i<nums.length;i++){
        //     if(set.contains(nums[i]))set.remove(nums[i]);
        //     else set.add(nums[i]);
        // }
        // Iterator<Integer> itr = set.iterator();
        // if(itr.hasNext())return itr.next();
        // return -1;

        int ans = 0;
        for(int i=0;i<nums.length;i++){
          ans = ans^ nums[i];
        }
        return ans;
    }
}