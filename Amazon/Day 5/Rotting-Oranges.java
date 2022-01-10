Problem Link : https://leetcode.com/problems/rotting-oranges/

class Solution {
    
    private int[][] dir={{-1,0},{0,1},{1,0},{0,-1}};
    
    int bfs(int[][] grid,int m,int n,List<int[]> start,int count){
        int ans=0;
        Queue<int[]> q=new LinkedList<>();
        for(int[] x:start){
            q.add(x);
            grid[x[0]][x[1]]=2;
        }    
        int c1=0;
        while(!q.isEmpty()){
            boolean f=false;
            int size=q.size();
            while(size-->0){
                int[] cur=q.poll();
                
                for(int i=0;i<4;i++){
                    int nexti=cur[0]+dir[i][0];
                    int nextj=cur[1]+dir[i][1];
                    if(nexti>=0 && nexti<m && nextj>=0 && nextj<n && grid[nexti][nextj]!=2 && grid[nexti][nextj]!=0){
                        grid[nexti][nextj]=2;
                        q.add(new int[]{nexti,nextj});
                        f=true;
                        c1++;
                    }
                }
            }
            if(f)ans++;
        }
        if(c1!=count) return -1;
        return ans;
    }
    
    public int orangesRotting(int[][] grid) {
        int m=grid.length,n=grid[0].length;
        List<int[]> al=new ArrayList<>();
        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    al.add(new int[]{i,j});
                }
                else if(grid[i][j]==1) count++;
            }
        }
        return bfs(grid,m,n,al,count);
    }
}
