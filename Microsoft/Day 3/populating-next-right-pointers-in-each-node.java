Problem Link : https://leetcode.com/problems/populating-next-right-pointers-in-each-node/

class Solution {
    public Node connect(Node root) {
        Queue<Node> q=new LinkedList<>();
        if(root==null) return root;
        q.add(root);
        Node cur=new Node(0);
        while(!q.isEmpty()){
            int size=q.size();
            while(size-->0){
                cur=q.poll();
                if(cur.left!=null){
                    q.add(cur.left);
                }
                if(cur.right!=null){
                    q.add(cur.right);
                    
                }
                if(q.peek()!=null){
                cur.next=q.peek();
                }
            }
            cur.next=null;
        }
        return root;
    }
}