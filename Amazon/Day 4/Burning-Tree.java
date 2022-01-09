Problem Link : https://practice.geeksforgeeks.org/problems/burning-tree/1/#

class Solution
{
    /*class Node {
    	int data;
    	Node left;
    	Node right;
    
    	Node(int data) {
    		this.data = data;
    		left = null;
    		right = null;
    	}
    }*/
    
    static Node parentMapping(Node root, int target,Map<Node,Node> hm){
        Queue<Node> q=new LinkedList<>();
        Node trgt=new Node(0);
        q.add(root);
        while(!q.isEmpty()){
            int size=q.size();
            while(size-->0){
                Node cur=q.poll();
                if(cur.data==target) trgt=cur;
                if(cur.left!=null){
                    hm.put(cur.left,cur);
                    q.add(cur.left);
                }
                if(cur.right!=null){
                    hm.put(cur.right,cur);
                    q.add(cur.right);
                }
            }
        }
        return trgt;
    }
    
    static int burnTree(Node root,Node trgt,Map<Node,Node> hm){
        
        Queue<Node> q=new LinkedList<>();
        q.add(trgt);
        int ans=0;
        Map<Node,Integer> seen=new HashMap<>();
        seen.put(trgt,1);
        
        while(!q.isEmpty()){
            int size=q.size();
            boolean flag=false;
            while(size-->0){
                Node cur=q.poll();
                if(cur.left!=null && !seen.containsKey(cur.left)){
                    flag=true;
                    q.add(cur.left);
                    seen.put(cur.left,1);
                }
                if(cur.right!=null && !seen.containsKey(cur.right)){
                    flag=true;
                    q.add(cur.right);
                    seen.put(cur.right,1);
                }
                Node parent=hm.get(cur);
                if(parent!=null && !seen.containsKey(parent)){
                    flag=true;
                    q.add(parent);
                    seen.put(parent,1);
                }
            }
            if(flag)ans++;
        }
        return ans;
    }
    
    public static int minTime(Node root, int target) 
    {
       if(root==null) return 0;
       Map<Node,Node> hm=new HashMap<>();
       Node trgt=parentMapping(root,target,hm);
       int ans=burnTree(root,trgt,hm);
       return ans;
    }
}