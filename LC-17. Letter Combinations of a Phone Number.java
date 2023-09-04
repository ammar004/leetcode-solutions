/*
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.


 

Example 1:

Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
Example 2:

Input: digits = ""
Output: []
Example 3:

Input: digits = "2"
Output: ["a","b","c"]
 

Constraints:

0 <= digits.length <= 4
digits[i] is a digit in the range ['2', '9']

*/


-----------------------------------------------------------------------
-----------------------------------------------------------------------


  //solution

  class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans=new ArrayList();
        if(digits.length()==0)
            return ans;

        HashMap<Character,String> map=new HashMap();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");

        combination(digits,0,map,new StringBuilder(),ans);
        return ans;
    }

    private static void combination(String digits,int i,HashMap<Character,String> map,StringBuilder sb, List<String> ans){
        if(i==digits.length())
        {
            ans.add(sb.toString());
            return;
        }

        String curr=map.get(digits.charAt(i));
        for(int j=0;j<curr.length();j++){
            sb.append(curr.charAt(j));
            combination(digits,i+1,map,sb,ans);
            sb.deleteCharAt(sb.length()-1);
        }

    }
}
