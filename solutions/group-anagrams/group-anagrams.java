import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        HashMap<String, List<String>> map = new HashMap();
        List<List<String>> anagrams = new ArrayList();

        for(int i = 0; i < strs.length; i++){
            char[] word = strs[i].toCharArray();
            
            Arrays.sort(word);
            String sortedWord = new String(word);

            if(map.get(sortedWord) != null){
                map.get(sortedWord).add(strs[i]);
            }else{
                List<String> group = new ArrayList<>();
                group.add(strs[i]);
                map.put(sortedWord, group);
            }
        }

        for(List<String> group : map.values()){
            anagrams.add(group);
        }

        return anagrams;
    }
}