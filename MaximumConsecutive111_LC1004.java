class Solution {
    public int longestOnes(int[] nums, int k) {
        int max = 0;
        int curr=0;
        int start = 0;
     for(int i=0;i<nums.length;i++){
        if(nums[i]==1){
         curr++;
        }
        else if (nums[i]==0){
          if(k>0){
            curr++;
            k--;
          }
          else {
            while(nums[start]==1){
                start++;
                curr--;
            }
            start++;
          }
        }
        max = Math.max(max,curr);
     }
     return max;
    }
}
// sliding window - if 1 curr me add krte jao aage bdte jao by doing j++ , 
// if 0 if k>0 curr me add krte jao aage bdte jao j++ krte jao 
// if 0 k==0 to jabtak 0 na miljaye tabtak i badhate jao curr- krte jao , aur last me k increase krdo by 1 , i by 1 and now repeat 
// before every j++ / index increment, do a comparision with max of curr


// 11100011110

// 004 0 , k = 2
       
