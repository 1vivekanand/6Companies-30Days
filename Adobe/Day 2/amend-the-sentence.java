Problem Link : https://practice.geeksforgeeks.org/problems/amend-the-sentence3235/1#

 class Solution{
    public String amendSentence(String s){
        
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++){
            char x=s.charAt(i);
            if(x>='a'&&x<='z'){
                sb.append(x);
            }
            else{
                sb.append(" ");
                sb.append((char)(x+32));
            }
        }
        return sb.toString().trim();
    }
}

