Problem Link : https://practice.geeksforgeeks.org/problems/number-of-unique-paths5339/1/

class Solution
{
    //Function to find total number of unique paths.
    public static int NumberOfPath(int a, int b) 
    {
        if(a==1 || b==1) return 1;
        int arr[][]=new int[a][b];
        for(int i=0;i<a;i++){
            arr[i][b-1]=1;
        }
        for(int i=0;i<b;i++){
            arr[a-1][i]=1;
        }
        for(int i=a-2;i>=0;i--){
            for(int j=b-2;j>=0;j--){
                arr[i][j]=arr[i][j+1]+arr[i+1][j];
            }
        }
        return arr[0][0];
    }
}