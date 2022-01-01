Problem link : https://practice.geeksforgeeks.org/problems/print-anagrams-together/1/#

class Solution {
    public List<List<String>> Anagrams(String[] string_list) {
        Map<String,List<String>> map=new HashMap<>();
        for(String str:string_list){
            char arr[]=str.toCharArray();
            Arrays.sort(arr);
            String newStr=String.valueOf(arr);
            if(!map.containsKey(newStr)){
                List<String> list=new ArrayList<>();
                list.add(str);
                map.put(newStr,list);
            }
            else {
                map.get(newStr).add(str);
            }
        }
        return new ArrayList<>(map.values());
    }
}
