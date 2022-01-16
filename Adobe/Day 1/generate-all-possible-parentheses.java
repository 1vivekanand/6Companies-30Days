Problem Link : https://practice.geeksforgeeks.org/problems/generate-all-possible-parentheses/1/#

class Solution {
    
    void fun(int open,int close,int n,String s,List<String> ans){
        if(s.length()==2*n){
            ans.add(s);
        }
        if(open<n){
            fun(open+1,close,n,s+"(",ans);
        }
        if(close<open){
            fun(open,close+1,n,s+")",ans);
        }
    }
    
    public List<String> AllParenthesis(int n) 
    {
        List<String> ans=new ArrayList<>();
        fun(0,0,n,"",ans);
        return ans;
    }
}