class Solution {
    public int[] productExceptSelf(int[] nums) {
        int product = 1;
        int[] lp = new int[nums.length];
        lp[0] = 1;
        int[] rp = new int[nums.length];
        rp[nums.length - 1] = 1;
        int[] answer = new int[nums.length];

        for(int i = 0; i < nums.length - 1; i++){
            product = product * nums[i];
            lp[i+1] = product;
        }
        product =1;
        for(int i = nums.length - 1; i > 0; i--){
            product = product * nums[i];
            rp[i-1] = product;
        }       
        for(int i = 0; i < nums.length; i++){
            answer[i] = lp[i] * rp[i];
        } 

        return answer;
    }
}