class Solution {
    public boolean isValid(String s) {

        Deque<Character> stack = new ArrayDeque<>();

        if(s.length() % 2 == 1)return false;
        
        for(int i = 0; i < s.length(); i++){
            if((s.charAt(i) == ')' || s.charAt(i) == '}' || s.charAt(i) == ']') && stack.isEmpty())return false;

            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '['){
                stack.push(s.charAt(i));
            }else if(s.charAt(i) == ')' ){
                if(stack.peek() == '('){
                    stack.pop();
                }else{
                    return false;
                }
            }else if(s.charAt(i) == '}'){
                if(stack.peek() == '{'){
                    stack.pop();
                }else{
                    return false;
                }
            }else if(s.charAt(i) == ']'){
                if(stack.peek() == '['){
                    stack.pop();
                }else{
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}