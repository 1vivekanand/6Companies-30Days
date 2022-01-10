Problem Link : https://leetcode.com/problems/serialize-and-deserialize-binary-tree/

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null) return "";
	    StringBuilder sb=new StringBuilder();
	    Queue<TreeNode> q=new LinkedList<>();
	    q.add(root);
	    sb.append(root.val+" ");
	    while(!q.isEmpty()){
	        int size=q.size();
	        while(size-->0){
	            TreeNode cur=q.poll();
	            if(cur.left!=null){
	                q.add(cur.left);
	                sb.append(cur.left.val+" ");
	            }
	            else sb.append("@ ");
	            if(cur.right!=null){
	                q.add(cur.right);
	                sb.append(cur.right.val+" ");
	            }
	            else sb.append("@ ");
	        }
	    }  
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String str) {
        if(str.length()==0) return null;
        Queue<TreeNode> q=new LinkedList<>();
        String arr[]=str.split(" ");
        TreeNode root=new TreeNode(Integer.parseInt(arr[0]));
        q.add(root);
        for(int i=1;i<arr.length;i++){
            TreeNode parent=q.poll();
            if(!arr[i].equals("@")){
                parent.left=new TreeNode(Integer.parseInt(arr[i]));
                q.add(parent.left);
            }
            i+=1;
            if(i<arr.length && !arr[i].equals("@")){
                parent.right=new TreeNode(Integer.parseInt(arr[i]));
                q.add(parent.right);
            }
        }
        return root;
    }
}
