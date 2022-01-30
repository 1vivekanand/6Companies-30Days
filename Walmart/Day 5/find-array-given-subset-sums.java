Problem Link : https://leetcode.com/problems/find-array-given-subset-sums/

class Solution {
    public int[] recoverArray(int n, int[] sums) {
        Arrays.sort(sums);
        int m = sums.length;
        int[] res = new int[n];
        int new_zero_spot = 0;        
        for (int i = 0; i < n; ++i) {
            int diff = sums[1] - sums[0], p = 0, k = 0;
            for (int j = 0; j < m; ++j) {
                if (k < p && sums[k] == sums[j]) k++;
                else sums[p++] = sums[j] + diff;
            }
            if (Arrays.binarySearch(sums, 0, m/2, new_zero_spot) >= 0){
                res[i] = -diff;
            } else {
                res[i] = diff;
                new_zero_spot += diff;
            }
            m /= 2;
        }
        return res;
    }
}