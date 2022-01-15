Problem Link : https://practice.geeksforgeeks.org/problems/alien-dictionary/1/#

class Solution
{
    void dfs(ArrayList<ArrayList<Integer>> adj,int s,Stack<Integer> st,boolean vis[]){
        vis[s]=true;
        for(int x:adj.get(s)){
            if(!vis[x]){
                dfs(adj,x,st,vis);
            }
        }
        st.push(s);
    }
    
    String topSort(ArrayList<ArrayList<Integer>> adj,int n){
        boolean vis[]=new boolean[n];
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++){
            dfs(adj,i,st,vis);
        }
        
        StringBuilder sb=new StringBuilder();
        while(!st.isEmpty()){
            sb.append((char)(st.pop()+'a'));
        }
        return sb.toString();
    }
    
    
    public String findOrder(String [] dict, int n, int k)
    {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<k;i++){
            adj.add(new ArrayList<>());
        }
        for(int j=0;j<dict.length-1;j++){
            String str1=dict[j];
            String str2=dict[j+1];
            for(int i=0;i<str1.length() && i<str2.length();i++){
                if(str1.charAt(i)!=str2.charAt(i)){
                    adj.get(str1.charAt(i)-'a').add(str2.charAt(i)-'a');
                    break;
                }
            }
        }
        return topSort(adj,k);
    }
}