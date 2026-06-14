class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        if(s.length()%2!=0) {
            return false;
        }
        
        for(int i=0; i<s.length(); i++) {
            Character c = s.charAt(i);
            if(c=='(' || c=='{' || c=='[') {
                stack.push(c);
            } else {
                if(stack.isEmpty()) {
                    return false;
                } else if(c==')' && stack.pop()!='(') {
                    return false;
                } else if(c=='}' && stack.pop()!='{') {
                    return false;
                } else if (c==']' && stack.pop()!='[') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
        
    }
}
