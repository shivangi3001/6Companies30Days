// Runtime 7 ms          Beats 81.80%

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st1 = new Stack<>();
        
        for(int i=0;i<tokens.length;i++){
            
            if(tokens[i].equals("+")){
                int val2 = st1.pop();
                int val1 = st1.pop();
                st1.push(val1+val2);
                 // System.out.println(tokens[i]);
            }
            else if(tokens[i].equals("-")){
                int val2 = st1.pop();
                int val1 = st1.pop();
                st1.push(val1-val2);
            }
            else if(tokens[i].equals("*")){
                int val2 = st1.pop();
                int val1 = st1.pop();
                st1.push(val1*val2);
            }
            else if(tokens[i].equals("/")){
                int val2 = st1.pop();
                int val1 = st1.pop();
                st1.push(val1/val2);
            }
            else st1.push(Integer.parseInt(tokens[i]));
                // System.out.println(tokens[i]+"---");
            
        }
        return st1.peek();
    }
}