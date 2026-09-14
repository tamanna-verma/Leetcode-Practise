class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i=0;i<n;i++)list.add(new ArrayList<>());

        for(List<Integer> edge : edges){
          int from = edge.get(0);
          int to = edge.get(1);
          list.get(to).add(from);
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0;i<list.size();i++){
             if(list.get(i).size()==0){
                ans.add(i);
             }
        }
        return ans;
    }
}
// minimum cost to reach = bfs 
// minimum no of edges = mst = 
// topological sort = indegree 