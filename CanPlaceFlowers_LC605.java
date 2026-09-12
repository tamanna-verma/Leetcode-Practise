class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int i = 0;
        int len = flowerbed.length;

        if (n == 0)
            return true;
        if (len == 1) {
            return flowerbed[0] == 0 ? n <= 1 : false;
        }
        while (i < len) {
            if (flowerbed[i] == 0
                    && (i == 0 || flowerbed[i - 1] == 0)
                    && (i == len - 1 || flowerbed[i + 1] == 0)) {
                n--;
                flowerbed[i] = 1;
            }
            i++;
        }
        return n <= 0;

    }
}