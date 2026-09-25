class Solution {
    public String reverseWords(String s) {
        char[] arr = s.toCharArray();

        int l = 0, r = 0, i = 0;
        reverse(arr,0,arr.length-1);
        while (i < arr.length) {
             while (i < arr.length && arr[i] == ' ') {
                i++;
            }

           if (i == arr.length) {

                break;

            }
            while (i < arr.length && arr[i] != ' ') {
                arr[r++] = arr[i++];
            }

            reverse(arr, l, r - 1);
             while (i < arr.length && arr[i] == ' ') {

                i++;

            }


            if (i < arr.length) {
                arr[r++] = ' ';
            }

            l = r;
        }

        return new String(arr, 0, r);
    }

    public void reverse(char[] arr, int i, int j) {
        while (i < j) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}
// reverse entire string , fir har small string ko reverse krte jate i ko bdate jao 3 pointer se hoga 
// left , right , i pointer honge , 