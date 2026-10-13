class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>();

        for(int num : nums){
            if(q.size() < k){
                q.offer(num);
            }else if(num > q.peek()){
                q.poll();
                q.offer(num);
            }
        }

        return q.poll();
    
    }

}