class Solution {
    public String trimTrailingVowels(String s) {
        StringBuilder str = new StringBuilder(s);
        int i = s.length() - 1;
        while (i >= 0 && isVowel(str.charAt(i)))
            i--;
        return str.substring(0, i + 1).toString();
    }

    public boolean isVowel(Character c) {
        return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');
    }
}