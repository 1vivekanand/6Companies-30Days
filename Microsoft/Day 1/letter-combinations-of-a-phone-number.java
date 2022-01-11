Problem Link : https://leetcode.com/problems/letter-combinations-of-a-phone-number/

class Solution {
    
    static List<String> fun(String digits,int n,String arr[]){
        if(n==0){
            List<String> al=new ArrayList<String>();
            al.add("");
            return al;
        }
        List<String> prev=fun(digits,n-1,arr);
        List<String> al=new ArrayList<String>();
        String cur=arr[digits.charAt(n-1)-'0'];
        for(char x:cur.toCharArray()){
            for(String y:prev){
                al.add(y+x);
            }
        }
        return al;
    }
    
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0) return new ArrayList<String>();
        String arr[]={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> al=fun(digits,digits.length(),arr);
        return al;
    }
}