class Solution {
    public int findJudge(int n, int[][] trust) {
        int count[] = new int [n+1];
        for(int[] pair : trust){
            int from = pair[0];
            int to = pair[1];
            count[to]+=1;
            count[from]=-1;
        }
        for(int i=1;i<=n;i++){
            if(count[i]==n-1)return i;
        }
        return -1;
    }
    //  public int findJudge(int n, int[][] trust) {
    //     int indegree[] = new int [n+1];
    //     int outdegree[] = new int [n+1];
    //     for(int[] pair : trust){
    //         int from = pair[0];
    //         int to = pair[1];
    //         indegree[to]++;
    //         outdegree[from]++;
    //     }
    //     for(int i=1;i<=n;i++){
    //         if(indegree[i]==n-1 && outdegree[i]==0)return i;
    //     }
    //     return -1;
    // }
}
// way 1 - maintain indegree  & outdegree , if outdegree 0 and indegree n-1 , thats the ans
//way 2- maintain count array , if going out , do count - 1 , if coming in , do count+=1 , if count = n-1 , its the ans