Problem Link : https://leetcode.com/problems/pacific-atlantic-water-flow/

class Solution {
    
    int dir[][]={{-1,0},{0,1},{1,0},{0,-1}};
    
    void bfs(int[][] heights,Queue<int[]> q,boolean vis[][]){
        int m=heights.length,n=heights[0].length;
        while(!q.isEmpty()){
            int cur[]=q.poll();
            for(int i=0;i<4;i++){
                int nexti=cur[0]+dir[i][0];
                int nextj=cur[1]+dir[i][1];
                if(nexti<0 || nextj<0 || nexti>=m || nextj>=n || vis[nexti][nextj] || heights[nexti][nextj]<heights[cur[0]][cur[1]]) continue;
                vis[nexti][nextj]=true;
                q.add(new int[]{nexti,nextj});
            }
        }
    }
    
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> ans=new ArrayList<>();
        int m=heights.length,n=heights[0].length;
        Queue<int[]> poq=new LinkedList<>();
        Queue<int[]> aoq=new LinkedList<>();
        boolean vispo[][]=new boolean[m][n];
        boolean visao[][]=new boolean[m][n];
        for(int i=0;i<n;i++){
            poq.add(new int[]{0,i});
            aoq.add(new int[]{m-1,i});
            vispo[0][i]=true;
            visao[m-1][i]=true;
        }
        for(int i=0;i<m;i++){
            poq.add(new int[]{i,0});
            aoq.add(new int[]{i,n-1});
            vispo[i][0]=true;
            visao[i][n-1]=true;
        }
        bfs(heights,poq,vispo);
        bfs(heights,aoq,visao);
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(visao[i][j] && vispo[i][j]) {
                    ans.add(Arrays.asList(i,j));
                }
            }
        }
        return ans;
    }
}