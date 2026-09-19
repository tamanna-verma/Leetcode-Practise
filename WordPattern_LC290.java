class Solution {
    public boolean wordPattern(String pattern, String s) {
       String words [] = s.split(" ");
       char alphabets [] = pattern.toCharArray();
       HashMap<Character,String> map = new HashMap<>();

       if(words.length!=alphabets.length)return false;
       for(int i=0;i<words.length;i++){
        String str = words[i];
        char c= alphabets[i];

        if(map.containsKey(c)){
           if(map.get(c).equals(str))continue;  
           else return false;
        }
        else if (map.containsValue(str))return false;
        map.put(c,str);
       }
       return true;
    }
}

// agar map me c hai aur value str hai uski value to it means hai 
// ya fir agar str hai , it mean vo kisi aur key ki value hai to return false

