Problem Link : https://practice.geeksforgeeks.org/problems/length-of-largest-region-of-1s-1587115620/1/#

class Solution
{
    //Function to find unit area of the largest region of 1s.
    
    int dfs(int[][] grid,int i,int j){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j]==0) return 0;
        grid[i][j]=0;
        return 1+dfs(grid,i-1,j)+dfs(grid,i,j+1)+dfs(grid,i+1,j)+dfs(grid,i,j-1)+dfs(grid,i-1,j+1)
        +dfs(grid,i+1,j+1)+dfs(grid,i+1,j-1)+dfs(grid,i-1,j-1);
    }
    
    public int findMaxArea(int[][] grid)
    {
        int ans=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    ans=Math.max(ans,dfs(grid,i,j));
                }
            }
        }
        return ans;
    }
}