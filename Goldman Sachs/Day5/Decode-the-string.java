Problem Link : https://practice.geeksforgeeks.org/problems/decode-the-string2444/1/#

class Solution{
    static String decodedString(String s){
        
        Stack<Character> st=new Stack<>();
        for(char x:s.toCharArray()){
            if(x==']'){
                String temp="";
                while(!st.isEmpty() && st.peek()!='['){
                    temp=st.pop()+temp;
                }
                st.pop();
                String count="";
                while(!st.isEmpty() && Character.isDigit(st.peek())){
                    count=st.pop()+count;
                }
                int cnt=Integer.parseInt(count);
                StringBuilder sb1=new StringBuilder();
                for(int i=0;i<cnt;i++){
                    sb1.append(temp);
                }
                for(char c:sb1.toString().toCharArray()){
                    st.push(c);
                }
            }
            else{
                st.push(x);
            }
        }
        
        StringBuilder ans=new StringBuilder();
        while(!st.isEmpty()){
            ans.append(st.pop());
        }
        return ans.reverse().toString();
    }
}
