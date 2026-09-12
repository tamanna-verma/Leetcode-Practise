class Solution {
    public String addStrings(String num1, String num2) {
        int index1 = num1.length() - 1;
        int index2 = num2.length() - 1;
        int carry = 0;
        StringBuilder str = new StringBuilder();
        int n1 = 0;
        int n2 = 0;

        while (index1 >= 0 || index2 >= 0 || carry != 0) {
            n1 = (index1 >= 0) ? (num1.charAt(index1) - '0') : 0;
            n2 = (index2 >= 0) ? (num2.charAt(index2) - '0') : 0;
            int sum = n1 + n2 + carry;
            carry = sum > 9 ? sum / 10 : 0;
            if (sum > 9)
                str.append(sum % 10);
            else
                str.append(sum);

            index1--;
            index2--;
        }
        return str.reverse().toString();

    }
}
//tabtak add kro jabtak har string ki length 0 na hojaye ya carry 0 na ho