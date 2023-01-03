//Solved on leetcode : https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/

class Solution {
    public int numberOfSubstrings(String s) {
        Queue<Integer> qa = new LinkedList<>();
        Queue<Integer> qb = new LinkedList<>();
        Queue<Integer> qc = new LinkedList<>();

        for(int i = 0; i<s.length(); i++){
            if(s.charAt(i)=='a')
                qa.add(i);
            else if(s.charAt(i)=='b')
                qb.add(i);
            else if(s.charAt(i)=='c')
                qc.add(i);
        }

        int ans =0, i = 0;
        while(!qa.isEmpty() && !qb.isEmpty() && !qc.isEmpty()){
            char ch = s.charAt(i);
            int v = 0; 

            if(ch == 'a'){
                v = Math.max(qb.peek(), qc.peek());
                qa.poll();
                
            }
            else if(ch == 'b'){
                v = Math.max(qa.peek(), qc.peek());
                qb.poll();
                
            }
            else if(ch == 'c'){
                v = Math.max(qb.peek(), qa.peek());
                qc.poll();
                
            }

            //our formula -- ans = ans + (n-v)
             ans = ans + (s.length()-v);
             i++;
        }
        return ans;
    }
}
