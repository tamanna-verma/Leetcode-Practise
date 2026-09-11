class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        TreeSet<Integer> set = new TreeSet<>();

        int i=0;
        int j=0;
        while(j<nums.length){

           if(j-i>indexDiff){
            set.remove(nums[i]);
            i++;
           }
           Object closestDiff = set.ceiling(nums[j]-valueDiff);//>= nums[j]-valuediff
           if(closestDiff !=null && Math.abs((Integer)closestDiff-nums[j])<=valueDiff)return true;
          set.add(nums[j]);
          j++;
        }
        return false;
    }
}

// keep i and j - on each j , check all value from i-j if value and diff condition match 

// keep i and j - store value in hashset - keep removing from hashset and increasing i when j-i is more than or equal to index diff and keep checking for all valudiff possible by traversing from 0-valuediff -> j-valuediff and if is there in set 

//keep i and j , and a treeset which is sorted obv , do a binary search on this treeset 