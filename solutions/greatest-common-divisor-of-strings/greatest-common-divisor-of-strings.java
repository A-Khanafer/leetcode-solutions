
class Solution {
    public String gcdOfStrings(String str1, String str2) {
        StringBuilder gcd = new StringBuilder();
        String best = "";

        // Choose the shorter string
        String shorter = str1.length() < str2.length() ? str1 : str2;

        for (char c : shorter.toCharArray()) {
            gcd.append(c);

            String candidate = gcd.toString();

            // Check whether the candidate divides BOTH strings
            if (isDivisor(str1, candidate) &&
                isDivisor(str2, candidate)) {
                best = candidate;
            }
        }

        return best;
    }

    private boolean isDivisor(String str, String candidate) {
        if (candidate.length() == 0 ||
            str.length() % candidate.length() != 0) {
            return false;
        }

        int i = 0;

        for (char c : str.toCharArray()) {
            if (c != candidate.charAt(i)) {
                return false;
            }

            i++;

            if (i == candidate.length()) {
                i = 0;
            }
        }

        return true;
    }
}
