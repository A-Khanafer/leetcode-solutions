class Solution {
    public boolean isPalindrome(String s) {
        int p1 = 0;
        int p2 = s.length() - 1;
        char left;
        char right;
        while(p1 <= p2){
            if(!Character.isLetterOrDigit(s.charAt(p1))){
                p1++;
                continue;   
            }
            left = Character.toLowerCase(s.charAt(p1));

            if(!Character.isLetterOrDigit(s.charAt(p2))){
                p2--;
                continue;
            }
            right = Character.toLowerCase(s.charAt(p2));

            if(left != right) return false;

            p1++;
            p2--;
        }
        return true;
    }
}