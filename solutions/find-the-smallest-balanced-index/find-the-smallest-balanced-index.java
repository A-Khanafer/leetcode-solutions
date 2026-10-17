/*class Solution {
    public int smallestBalancedIndex(int[] nums) {
        if(nums.length == 1) return -1;

        long rp = 1;
        long ls = 0;
        long maxSum = 0;

        for(int num : nums){
            maxSum += num;
        }

        maxSum -= nums[0];

        for(int i = 1; i < nums.length; i++){

            if (rp > Long.MAX_VALUE / nums[i]) {
                // Multiplication would overflow
            } else {
                rp *= nums[i];
            }

        }

        for(int i = 1; i < nums.length; i++){
            long lsNext =(long) ls + nums[i - 1];
            long rpNext =(long) rp / nums[i];

            if(lsNext == rpNext) return i;

            ls = lsNext;
            rp = rpNext;
        }

        return -1;
    }
}*/

class Solution {
    public int smallestBalancedIndex(int[] nums) {
        if (nums.length == 1) return -1;

        long rp = 1;
        long ls = 0;
        long maxSum = 0;

        for (int num : nums) {
            maxSum += num;
        }

        int start = 1;

        // Build the right product safely
        for (int i = nums.length - 1; i >= 2; i--) {
            if (rp > maxSum / nums[i]) {
                start = i;
                break;
            }

            rp *= nums[i];
        }

        // Calculate left sum before starting index
        for (int i = 0; i < start; i++) {
            ls += nums[i];
        }

        // Your original left-to-right approach
        for (int i = start; i < nums.length; i++) {
            if (ls == rp) return i;

            ls += nums[i];

            if (i + 1 < nums.length) {
                rp /= nums[i + 1];
            }
        }

        return -1;
    }
}