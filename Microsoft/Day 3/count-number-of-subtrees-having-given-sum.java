Problem Link : https://practice.geeksforgeeks.org/problems/count-number-of-subtrees-having-given-sum/1/#

class Tree
{
    //Function to count number of subtrees having sum equal to given sum.
   
    class res{
        int ans=0;
    }
    
    // convert the tree into a sum Tree
    int sumTree(Node root){
        if(root==null) return 0;
        if(root.left==null && root.right==null) return root.data;
        root.data=root.data+sumTree(root.left)+sumTree(root.right);
        return root.data;
    }
    
    void countSum(Node root,int sum,res r){
        if(root==null) return;
        if(root.data==sum) r.ans+=1;
        countSum(root.left,sum,r);
        countSum(root.right,sum,r);
    }
    
    int countSubtreesWithSumX(Node root, int sum)
    {
        if(root==null) return 0;
        res r=new res();
        sumTree(root);
        countSum(root,sum,r);
        return r.ans;
    }
}