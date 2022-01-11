Problem Link : https://practice.geeksforgeeks.org/problems/rotate-by-90-degree0356/1/#

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