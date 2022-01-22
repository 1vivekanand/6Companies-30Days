Problem Link : https://leetcode.com/problems/number-of-provinces/

class Solution {
    
    static void dfs(int [][] isConnected,int v,boolean[] visited){
        visited[v]=true;
        for(int i=0;i<isConnected.length;i++){
            if(isConnected[v][i]==1 && visited[i]==false){
                dfs(isConnected,i,visited);
            }
        }
    }
    
    public int findCircleNum(int[][] isConnected) {
        int count=0,n=isConnected.length;
        boolean visited[]=new boolean[n];
        for(int i=0;i<n;i++){
            if(visited[i]==false){
                dfs(isConnected,i,visited);
                count++;
            }
        }
        return count;
    }
}