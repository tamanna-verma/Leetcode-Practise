class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> previous = new HashSet<Integer>();    
        int i=0;
        int j=0;
        while(j<nums.length)
        {
           if(j-i>k){
             previous.remove(nums[i]);
             i++;
           }           
            if(previous.contains(nums[j]))return true;
            previous.add(nums[j]);
            j++;
        }
        return false;
    }
}
//1 2 3 0 0 2 2 3