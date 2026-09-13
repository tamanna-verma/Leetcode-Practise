class Solution {
    public static HashMap<String, Boolean> dp;

    public boolean pyramidTransition(String bottom, List<String> allowed) {
        HashMap<String, ArrayList<Character>> map = new HashMap<>();
        for (int i = 0; i < allowed.size(); i++) {
            String str1 = allowed.get(i).substring(0, 2);
            Character c = allowed.get(i).charAt(2);

            ArrayList<Character> list = new ArrayList<Character>();
            if (map.containsKey(str1)) {
                list = map.get(str1);
            }
            list.add(c);
            map.put(str1, list);
        }
        dp = new HashMap<>();
        StringBuilder newBottom = new StringBuilder("");
        return helper(bottom, 0, map, newBottom);

    }

    public static boolean helper(String bottom, int index, HashMap<String, ArrayList<Character>> map,
            StringBuilder newBottom) {
        
        if (newBottom.length() == 1 && index == bottom.length()-1)
            return true;

        if(dp.containsKey(bottom+newBottom+index))return false;
        if (index + 1 >= bottom.length()) return helper(newBottom.toString(), 0 , map , new StringBuilder(""));
        
        StringBuilder pair = new StringBuilder("");
        pair.append(bottom.charAt(index));
        pair.append(bottom.charAt(index + 1));

        if (! map.containsKey(pair.toString())) return false;
        ArrayList<Character> secondParts = map.get(pair.toString());

        for (int i = 0; i < secondParts.size(); i++) {
            newBottom.append( secondParts.get(i) ); // do 
                if( helper(bottom, index + 1, map, newBottom)) return true ;
            newBottom.deleteCharAt(newBottom.length() - 1); // undo 
        }

        dp.put((bottom+newBottom+index),false);
        return false;
    }
}
// split all allowed list into first 2 and last 1 , put in a hashamp compare first 2 ka pair with bottoms i,i+1 ka pair
// bottom k har 2 char ka pair ko check kro , 
// bottom , newBottom , index pass all 3 into a recursion , keep checking everytime for that index i , there can be multiple options for 1 index , check all using all possible options , and put in a dp and check everytime in dp if this combination exist in dp
// in dp , put a string bottom +newbottom+ index
// base case if index==bottom.length-1 && newbottom ==1 return true;