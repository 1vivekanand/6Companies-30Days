Problem Link : https://leetcode.com/problems/spiral-matrix/

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> al=new ArrayList<Integer>();
        int r=matrix.length,c=matrix[0].length;
        int rb=0,re=r-1,cb=0,ce=c-1;
        while(rb<=re && cb<=ce){
            for(int i=cb;i<=ce;i++){
                al.add(matrix[rb][i]);
            }
            rb++;
            for(int i=rb;i<=re;i++){
                al.add(matrix[i][ce]);
            }
            ce--;
            if(rb<=re){
                for(int i=ce;i>=cb;i--){
                    al.add(matrix[re][i]);
                }
            }
            re--;
            if(cb<=ce){
                for(int i=re;i>=rb;i--){
                    al.add(matrix[i][cb]);
                }
            }
            cb++;
        }
        return al;
    }
}