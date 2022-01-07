Problem Link : https://practice.geeksforgeeks.org/problems/brackets-in-matrix-chain-multiplication1024/1/#

class Solution {

    static class ans {
        static String st = "";
        static char name;

    }


    static void printParenthesis(int i, int j, int n, int[][] bracket, ans a) {

        if (i == j) {
            a.st += a.name;
            a.name++;
            return;
        }
        a.st += '(';
        printParenthesis(i, bracket[i][j], n, bracket, a);
        printParenthesis(bracket[i][j] + 1, j, n, bracket, a);
        a.st += ')';
    }

    static String matrixChainOrder(int p[], int n) {

        ans a = new ans();

        int m[][] = new int[n][n];
        int bracket[][] = new int[n][n];
        for (int i = 1; i < n; i++)
            m[i][i] = 0;
        for (int L = 2; L < n; L++) {
            for (int i = 1; i < n - L + 1; i++) {
                int j = i + L - 1;
                m[i][j] = Integer.MAX_VALUE;
                for (int k = i; k <= j - 1; k++) {
                    int q = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j];
                    if (q < m[i][j]) {
                        m[i][j] = q;
                        bracket[i][j] = k;
                    }
                }
            }
        }
        a.name = 'A';
        printParenthesis(1, n - 1, n, bracket, a);
        return a.st;
    }
}