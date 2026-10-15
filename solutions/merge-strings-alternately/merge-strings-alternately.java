class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder merged = new StringBuilder();

        int maxIndex = Math.min(word1.length(), word2.length());

        for(int i = 0; i < maxIndex; i++){
            merged.append(word1.charAt(i));
            merged.append(word2.charAt(i));
        }
        
        if(word1.length() < word2.length()){
           merged.append(word2.substring(maxIndex));
        }else if(word2.length() < word1.length()){
           merged.append(word1.substring(maxIndex));
        }

        return merged.toString();       

    }
}