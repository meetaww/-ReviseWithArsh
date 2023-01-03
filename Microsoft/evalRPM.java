//Solved on Leetcode : https://leetcode.com/problems/evaluate-reverse-polish-notation/description/

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String op : tokens){
            
            if("+-/*".contains(op)){
                int opd2 = stack.pop();
                int opd1 = stack.pop();
                stack.push(evaluate(opd1, opd2, op));
            }
                
            else
                stack.push(Integer.parseInt(op));    // parseInt()is used to parse the string value as a signed decimal value
        }
    return stack.pop();
    }


    public int evaluate(int a, int b, String op){
        if("+".equals(op))
            return a +b;
        if("-".equals(op))
            return a-b;
        if("*".equals(op))
            return a*b;
        else
            return a /b;
    }
}
