/*
Given a string s representing a valid expression, implement a basic calculator to evaluate it, and return the result of the evaluation.

Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().

 

Example 1:

Input: s = "1 + 1"
Output: 2
Example 2:

Input: s = " 2-1 + 2 "
Output: 3
Example 3:

Input: s = "(1+(4+5+2)-3)+(6+8)"
Output: 23
 

Constraints:

1 <= s.length <= 3 * 105
s consists of digits, '+', '-', '(', ')', and ' '.
s represents a valid expression.
'+' is not used as a unary operation (i.e., "+1" and "+(2 + 3)" is invalid).
'-' could be used as a unary operation (i.e., "-1" and "-(2 + 3)" is valid).
There will be no two consecutive operators in the input.
Every number and running calculation will fit in a signed 32-bit integer.

*/


------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------


  //solution

  class Solution {
    public int calculate(String s) {
        Stack<Integer> st=new Stack();
        int ans=0,num=0,sign=1;
        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            if(Character.isDigit(c))
                num=num*10+(int)(c-'0');
            else if(c=='+'){
                ans+=sign*num;
                num=0;
                sign=1;
            }
            else if(c=='-'){
                ans+=sign*num;
                num=0;
                sign=-1;              
            }
            else if(c=='('){
                st.push(ans);
                st.push(sign);
                sign=1;
                ans=0;
            }
            else if(c==')'){
                ans+=sign*num;
                num=0;
                ans*=st.pop();
                ans+=st.pop();
            }
        }
        if(num!=0)
            ans+=sign*num;
        return ans;
    }
}
