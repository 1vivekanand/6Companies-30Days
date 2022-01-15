Problem Link : https://practice.geeksforgeeks.org/problems/bridge-edge-in-graph/1#

class Solution
{
    //Function to find if the given edge is a bridge in graph.
    
    static void dfs(ArrayList<ArrayList<Integer>> adj,boolean vis[],int s){
        vis[s]=true;
        for(int x:adj.get(s)){
            if(!vis[x]){
                dfs(adj,vis,x);
            }
        }
    }
    
    static int isBridge(int v, ArrayList<ArrayList<Integer>> adj,int c,int d)
    {
        
        boolean vis[]=new boolean[v];
        int prev=0;
         for(int i=0;i<v;i++){
            if(!vis[i]){
                dfs(adj,vis,i);
                prev++;
            }
        }
        Arrays.fill(vis,false);
        adj.get(c).remove(new Integer(d));
        adj.get(d).remove(new Integer(c));
        int count=0;
        for(int i=0;i<v;i++){
            if(!vis[i]){
                dfs(adj,vis,i);
                count++;
            }
        }
        return count==prev?0:1;
    }
}