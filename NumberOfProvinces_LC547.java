class Solution {
    boolean visited[];
    public int findCircleNum(int[][] isConnected) {
    int n = isConnected.length;
       visited = new boolean[n];
       int count=0;
        for(int i=0;i<n;i++){
            if(visited[i]==false){
                count++;
                dfs(i,-1,isConnected);
            }
        }
     return count;
    }
   public void dfs(int node , int parent , int[][] isConnected){
    //System.out.println(node);
       visited[node]=true; 
       int [] neighbours = isConnected[node];
         for(int i=0;i<neighbours.length;i++){
            if(neighbours[i]==1 && visited[i]==false && i!=parent){
                dfs(i,node,isConnected);
            }
         }
   }
}

// har row ko adj list smjo of nodes its connected to 