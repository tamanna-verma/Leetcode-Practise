class Solution {
    public int slidingPuzzle(int[][] board) {
        // shortest path to the desired string , minimum path - graph - bfs - queue + steps
        StringBuilder str = new StringBuilder();
        String desired = "123450";
        for(int i=0;i<2;i++){
            for(int j=0;j<3;j++){
              str.append((char)('0'+board[i][j]));
            }
        }
        HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
        map.put(0,new ArrayList<>(Arrays.asList(1,3)));
        map.put(1,new ArrayList<>(Arrays.asList(0,2,4)));
        map.put(2,new ArrayList<>(Arrays.asList(1,5)));
        map.put(3,new ArrayList<>(Arrays.asList(0,4)));
        map.put(4,new ArrayList<>(Arrays.asList(1,3,5)));
        map.put(5,new ArrayList<>(Arrays.asList(2,4)));
        // now i have my string ready
        Queue<String> queue = new ArrayDeque<>();
        HashSet<String> set = new HashSet<>();
        set.add(str.toString());
        queue.add(str.toString());
        int steps = 0;
        
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size>0){
                String popped = queue.remove();
                if(popped.equals(desired))return steps;

                int x = findIndex(popped);
                ArrayList<Integer> neighInd = map.get(x);
                for(int i=0;i<neighInd.size();i++){
                    String newstr = swap(popped ,neighInd.get(i),x);
                    if(!set.contains(newstr)){
                        set.add(newstr);
                        queue.add(newstr);
                    }
                }
                size--;
            }
             steps++;
        }
        return -1;
    }
    public static String swap(String str , int i , int j){
        StringBuilder newstr = new StringBuilder(str);//copy
        char temp = newstr.charAt(i);
        newstr.setCharAt(i,newstr.charAt(j));
        newstr.setCharAt(j,temp);
        return newstr.toString();
    }
    public int findIndex(String str){
       return str.indexOf('0');
    }
}
//queue me se remove , do all 3 steps if not in hashmap then put in queue ,check of what can it move from this index from the hashamp where we can check what all 2/3 steps it can move from here ,  make a hashmap for visited