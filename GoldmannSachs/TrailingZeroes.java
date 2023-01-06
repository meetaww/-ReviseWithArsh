//Solved on Leetcode : https://leetcode.com/problems/factorial-trailing-zeroes/description/

class Solution {
    public int trailingZeroes(int n) {
        if(n<5)         //less than 5 will have a 2 but not a 5 so there will be no 10; hence no 0
            return 0;
        else
            return n/5 + trailingZeroes(n/5);   //here, we have only considered 5 because when we include a 5 there is always a 2 included, so 5*2=10; hence that many zeroes
    }
}

