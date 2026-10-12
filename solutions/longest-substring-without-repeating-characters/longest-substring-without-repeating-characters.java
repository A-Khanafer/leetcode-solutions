class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) return 0;

        int left = 0, right = 0;
        int maxLength = 1;

        HashMap<Character, Integer> lastSeen = new HashMap();
        lastSeen.put(s.charAt(0), 0);

        while(right < s.length() - 1){

            right++;
            if(lastSeen.containsKey(s.charAt(right))){
                left = Math.max(left, lastSeen.get(s.charAt(right)) + 1);
                lastSeen.put(s.charAt(right), right);
            }else{
                lastSeen.put(s.charAt(right), right);
            }

            int length = right - left + 1;
            if(length > maxLength) maxLength = length;

        }

        return maxLength;
    }
}