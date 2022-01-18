Problem Link : https://practice.geeksforgeeks.org/problems/implement-atoi/1/#

class Solution
{
    int fun(String str,int idx){
        boolean f=true;
        int ans=0;
        for(int i=idx;i<str.length();i++){
    	    char x=str.charAt(i);
    	    if((x-'0'>=0) && (x-'0'<=9)){
    	        ans*=10;
    	        ans+=(x-'0');
    	    }
    	    else {
    	        f=false;
    	        break;
    	    }
    	}
        return f==false?-1:ans;
    }
    
    int atoi(String str) {
    	boolean isNegative=false;
    	if(str.charAt(0)=='-') isNegative=true;
    	if(isNegative==true){
    	    return -1*fun(str,1);
    	}
    	return fun(str,0);
    }
}
