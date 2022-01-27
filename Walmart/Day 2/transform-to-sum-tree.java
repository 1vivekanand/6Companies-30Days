Problem Link : https://practice.geeksforgeeks.org/problems/transform-to-sum-tree/1/

class Solution{
    int sumTree(Node root){
        if(root==null) return 0;
        if(root.left==null && root.right==null) {
            return root.data;
        }
        int temp=root.data;
        root.data=sumTree(root.left)+sumTree(root.right);
        return root.data+temp;
    }
    
    public void toSumTree(Node root){
         //add code here.
         sumTree(root);
    }
}