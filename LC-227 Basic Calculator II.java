/*
Given a string s which represents an expression, evaluate this expression and return its value. 

The integer division should truncate toward zero.

You may assume that the given expression is always valid. All intermediate results will be in the range of [-231, 231 - 1].

Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().

 

Example 1:

Input: s = "3+2*2"
Output: 7
Example 2:

Input: s = " 3/2 "
Output: 1
Example 3:

Input: s = " 3+5 / 2 "
Output: 5
 

Constraints:

1 <= s.length <= 3 * 105
s consists of integers and operators ('+', '-', '*', '/') separated by some number of spaces.
s represents a valid expression.
All the integers in the expression are non-negative integers in the range [0, 231 - 1].
The answer is guaranteed to fit in a 32-bit integer.
*/


----------------------------------------------------------------------------------------------------


  //solution

  class Solution {
    public int calculate(String s) {
        Stack<Integer> st=new Stack();
        int num=0;
        char operator='+';

        char ch[]=s.toCharArray();
        for(int i=0;i<ch.length;i++)
        {
            if(Character.isDigit(ch[i]))
                num=num*10+ch[i]-'0';
            if(!Character.isDigit(ch[i]) && ch[i]!=' ' || i==ch.length-1)
            {
                if(operator=='+')
                    st.push(num);
                else if(operator=='-')
                    st.push(-num);
                else if(operator=='*')
                    st.push(st.pop()*num);
                else if(operator=='/')
                    st.push(st.pop()/num);
                num=0;
                operator=ch[i];

            }
        }

        int sum=0;
        while(!st.isEmpty())
        {
            sum+=st.pop();
        }

        return sum;

    }
}
