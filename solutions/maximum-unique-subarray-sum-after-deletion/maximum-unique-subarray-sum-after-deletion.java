class Solution {
    public int maxSum(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        int max = nums[0];

        for(int i = 0; i < nums.length; i++){
            if(nums[i] >= 0){
                set.add(nums[i]);
            }

            if( nums[i] > max) max = nums[i];

        }

        if(max < 0) return max;

        int result = 0;

        for(Integer num : set){
            result += num;
        }

        return result;

    }
}