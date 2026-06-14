class Solution {
    public boolean isValid(String s) {
        
        int length = s.length();
        Deque<Character> stack = new ArrayDeque<>();

        for(int i=0; i<length; i++) {
            Character c=s.charAt(i);
            if(c=='(' || c=='{' || c=='[') {
                stack.push(c);
            } else {
                Character k;
                if(stack.isEmpty()) {
                    return false;
                } else {
                    k = stack.pop();
                }
                switch (c){
                    case ')':
                        if(k!='(') return false;
                        break;

                    case '}':
                        if (k!='{') return false;
                        break;

                    case ']':
                        if(k!='[') return false;
                    break;

                    default:
                }
            }
        }
        if(stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
        
    }
}
