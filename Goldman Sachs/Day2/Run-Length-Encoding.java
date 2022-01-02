Problem Link : https://practice.geeksforgeeks.org/problems/run-length-encoding/1

class GfG
 {
	String encode(String str)
	{
        int count=1;
        char cur=str.charAt(0);
        StringBuilder sb=new StringBuilder();
        for(int i=1;i<str.length();i++){
            char s=str.charAt(i);
            if(s==cur){
                count++;
            }
            else{
                sb.append(cur);
                sb.append(count);
                cur=s;
                count=1;
            }
        }
        sb.append(cur);
        sb.append(count);
        return sb.toString();
	}
	
 }