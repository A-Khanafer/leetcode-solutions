class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        

        Deque<int[]> stack = new ArrayDeque<>();
        int[] count = new int[temperatures.length];

        for(int i = 0; i < temperatures.length; i++){

            if(i == 0 || (stack.isEmpty() && i != temperatures.length -1)){
                stack.push(new int[]{i, temperatures[i]});
                continue;
            }

            if(!stack.isEmpty()){
                if(stack.peek()[1] >= temperatures[i]){
                    stack.push(new int[]{i, temperatures[i]});
                    continue;
                }
                int[] temp = stack.pop();
                count[temp[0]] = i - temp[0];
                i--;
            }
        }

        count[temperatures.length - 1] = 0;

        return count;
    }
}