//Solved on Leetcode : https://leetcode.com/problems/longest-happy-prefix/description/

class Solution {
    public String longestPrefix(String s) {
        int j=0;
        int dp[] = new int[s.length()];

        for( int i=1; i<s.length(); i++){
            if(s.charAt(i)== s.charAt(j)){
                dp[i] = ++j;

            }
            else if(j>0){
                j=dp[j-1];
                i--;
            }
        }

        return s.substring(0,j);
    }
}

//referred kmp and the solution proocess here --> https://leetcode.com/problems/longest-happy-prefix/solutions/547446/c-java-with-picture-incremental-hash-and-kmp/

