class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(Character c: s.toCharArray()){
            if(c=='('||c=='['||c=='{')stack.push(c);
            else if(stack.isEmpty())return false;
            else if((c==')'&& stack.peek()=='(')||(c==']'&& stack.peek()=='[')||(c=='}'&& stack.peek()=='{'))stack.pop();
            else if((c==')'&& stack.peek()!='(')||(c==']'&& stack.peek()!='[')||(c=='}'&& stack.peek()!='{'))return false;
        }
        return stack.isEmpty();
    }
}