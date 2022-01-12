Problem Link : https://practice.geeksforgeeks.org/problems/rotate-by-90-degree0356/1/#

Approach 1 : Two pass

class GFG
{
    static void swap(int[][] matrix,int i,int j){
        int temp=matrix[i][j];
        matrix[i][j]=matrix[j][i];
        matrix[j][i]=temp;
    }
    
    static void rotate(int matrix[][]) 
    {
        int r=matrix.length,c=matrix[0].length;
        int c1=0;
        c-=1;
        while(c1<c){
            for(int i=0;i<r;i++){
                int temp=matrix[i][c1];
                matrix[i][c1]=matrix[i][c];
                matrix[i][c]=temp;
            }
            c1++;
            c--;
        }
        c=r;
        
        for(int i=0;i<r;i++){
            for(int j=i+1;j<c;j++){
                swap(matrix,i,j);
            }
        }
    }
}

Problem Link : https://leetcode.com/problems/rotate-image/

Approach 2: Single pass

class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

	// take 4 corner element and rotate them
        for (int i = 0; i < (n + 1) / 2; i ++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - j - 1];
                matrix[n - 1 - i][n - j - 1] = matrix[j][n - 1 -i];
                matrix[j][n - 1 - i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
    }
}


