Problem Link : https://practice.geeksforgeeks.org/problems/first-non-repeating-character-in-a-stream1216/1#

class Solution
{
    public String FirstNonRepeating(String s)
    {
        StringBuilder sb=new StringBuilder();
        Queue<Character> q=new LinkedList<>();
        int arr[]=new int[26];
        for(int i=0;i<s.length();i++){
            char cur=s.charAt(i);
            if(arr[cur-'a']==0){
                q.add(cur);
            }
            arr[cur-'a']++;
            while(!q.isEmpty() && arr[q.peek()-'a']!=1){
                q.poll();
            }
            if(q.isEmpty()){
                sb.append('#');
            }
            else{
                sb.append(q.peek());
            }
        }
        return sb.toString();
    }
}