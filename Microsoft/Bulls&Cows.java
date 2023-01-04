//Solved on Leetcode : https://leetcode.com/problems/bulls-and-cows/description/

class Solution {
    public String getHint(String secret, String guess) {
        // we try to solve it using a frequency array of size 10 (elements from [0-9] are present here)

        int bulls =0, cows=0;
        int freqArray[] = new int[10];

        for(int i=0; i<secret.length(); i++){
            int s = secret.charAt(i) - '0';
            int g = guess.charAt(i) - '0';

            if(s==g)
                bulls++;
            else {
                if(freqArray[s] < 0)  cows ++;
                if(freqArray[g] > 0)  cows ++;

                freqArray[s]++;
                freqArray[g]--;
            }


        }

        return bulls + "A" + cows + "B";
    }
}
