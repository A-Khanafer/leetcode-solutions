class Solution {
    public int climbStairs(int n) {
        if(n <= 2) return n;

        int current = 2;
        int previous = 1;

        for(int i = 3; i <= n; i++){
            int next = i;

            next = current + previous;

            previous = current;
            current = next;
        }

        return current;
    }
}