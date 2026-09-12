class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {

        List<String> ans = new ArrayList<String>();

        int i = 0;
        int j = 0;
        int n = words.length;

        while (i < n) {

            // Start j from current word
            j = i;

            int number = words[i].length();

            // Find words that fit in this line
            while (j + 1 < n) {

                if (number + words[j + 1].length()
                        + (j + 1 - i) <= maxWidth) {

                    number += words[j + 1].length();
                    j++;

                } else {
                    break;
                }
            }

            int blanks = maxWidth - number;
            int gap = j - i;

            StringBuilder str = new StringBuilder("");

            // Last line OR only one word
            if (j == n - 1 || gap == 0) {

                for (int k = i; k <= j; k++) {

                    str.append(words[k]);

                    if (k < j) {
                        str.append(" ");
                    }
                }

                // Remaining spaces at the end
                while (str.length() < maxWidth) {
                    str.append(" ");
                }

            } else {

                int space = blanks / gap;
                int extra = blanks % gap;

                for (int k = i; k <= j; k++) {

                    str.append(words[k]);

                    // Add spaces only after a word
                    if (k < j) {

                        int spacesToAdd = space;

                        if (extra > 0) {
                            spacesToAdd++;
                            extra--;
                        }

                        for (int l = 0; l < spacesToAdd; l++) {
                            str.append(" ");
                        }
                    }
                }
            }

            ans.add(str.toString());

            // Move to first word of next line
            i = j + 1;
        }

        return ans;
    }
}

// har ek word + (j-i) should be less than maxwidth 
// fir number of blanks dekho , unko equally divide kro = n/3 , aur jo extra hoge n%3 , unko first n%3 gaps me 1 extra daldo 