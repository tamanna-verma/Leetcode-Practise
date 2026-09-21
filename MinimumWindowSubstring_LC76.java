class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> requiredFreq = new HashMap<>();
        HashMap<Character, Integer> currentFreq = new HashMap<>();
        int requiredNumber = t.length();
        int numbers = 0;
        int minAns = Integer.MAX_VALUE;
        String ans = "";

        for (Character c : t.toCharArray()) {
            int freq = requiredFreq.getOrDefault(c, 0);
            requiredFreq.put(c, freq + 1);
        }

        int i = 0;
        int j = 0;

        while (j < s.length()) {
            Character c = s.charAt(j);
            int currVal = currentFreq.getOrDefault(c, 0);
            int reqVal = requiredFreq.getOrDefault(c, 0);
            if (requiredFreq.containsKey(c) && currVal < reqVal) {
                numbers++;
            }
            currentFreq.put(c, currVal + 1);
            while (numbers == requiredNumber) {
                if (minAns > j - i + 1) {
                    minAns = j - i + 1;
                    ans = s.substring(i, j + 1);
                }
                Character left = s.charAt(i);
                int val = currentFreq.get(left);
                currentFreq.put(left, val - 1);
                if (requiredFreq.containsKey(left)
                        && val <= requiredFreq.get(left)) {
                    numbers--;
                }
                i++;
            }
            j++
        }

        return ans;
    }
}
