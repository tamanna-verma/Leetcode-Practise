class Solution {
    boolean visited[];
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i=0;i<=n;i++){
        list.add(new ArrayList<Integer>());
        }
    
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(isConnected[i][j]==1){
                    list.get(i+1).add(j+1);
                    list.get(j+1).add(i+1);
                    System.out.println((i+1) + " " + (j+1));
                }
            }
        }
       visited = new boolean[n+1];
       int count=0;
        for(int i=1;i<=n;i++){
            if(visited[i]==false){
                count++;
                dfs(i,-1,list);
            }
        }
     return count;
    }
   public void dfs(int node , int parent , ArrayList<ArrayList<Integer>> list){
    //System.out.println(node);
         visited[node]=true; 
         ArrayList<Integer> neighbours = list.get(node);
         for(int i=0;i<neighbours.size();i++){
            int neigh = neighbours.get(i);
            if(visited[neigh]==false && neigh!=parent){
                dfs(neigh,node,list);
            }
         }
   }
}