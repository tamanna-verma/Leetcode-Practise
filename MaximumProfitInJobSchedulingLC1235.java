class Solution {
    int n;
    int dp[];

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        n = startTime.length;
        int arr[][] = new int[n][3];
        dp = new int[n];
        Arrays.fill(dp,-1);
        for (int i = 0; i < n; i++) {
            arr[i][0] = startTime[i];
            arr[i][1] = endTime[i];
            arr[i][2] = profit[i];
        }

        // sort kardo according to the start time;
        Arrays.sort(arr, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });

         return solve (arr,0);

    }

    public int findNext(int arr[][], int left , int currentJobEnd){
        int right = n-1;
        int ans = n+1;
        while(left<=right){
            int mid = left+(right-left)/2;

            if(arr[mid][0]>=currentJobEnd ){
             ans= mid;
             right = mid-1;
            }
            else left = mid+1;
        }
        return ans;
    }

    public int solve(int [][] arr , int index){
      if(index>=n) return 0;

      if(dp[index]!=-1)return dp[index];
      int next = findNext(arr , index+1 , arr[index][1]);
      int taken = arr[index][2] + solve(arr, next);
      int not_taken = solve(arr,index+1);
       
       
       return dp[index]= Math.max(taken,not_taken);
    }
}

//find next me arr pass hoga , aur fir pass karo , current end , and it will be returning so many arr of start , end , profit 

// helper me arr pass krege , we will pass a

// SLIDING WINDOW
// BINARY SEARCH 
// SHORTEST PATH 
// MINIMUM STEPS 
// DP 
// GRAPH 
// LINKEDLIST
// PREFIX SUFFIX 
