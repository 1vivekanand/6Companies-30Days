Problem Link : https://leetcode.com/problems/word-search/

class Solution {
    
    private int[][] dir={{-1,0},{0,1},{1,0},{0,-1}};
    
    boolean possible(char[][] board, String word,int i,int j,int pos){
        int m=board.length,n=board[0].length;
        if(pos==word.length()) return true;
        if(i<0 || i>=m || j<0 || j>=n || board[i][j]!=word.charAt(pos)) return false;
        board[i][j]^=256;
        boolean res= possible(board,word,i+1,j,pos+1) || possible(board,word,i-1,j,pos+1) ||possible(board,word,i,j+1,pos+1)   ||possible(board,word,i,j-1,pos+1);
         board[i][j]^=256;
        return res;
        
    }
    
    public boolean exist(char[][] board, String word) {
        
        int m=board.length,n=board[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(possible(board,word,i,j,0)==true){
                    return true;
                }                
            }
        }
        return false;
    }
}