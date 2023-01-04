//Solved on Leetcode : https://leetcode.com/problems/rotate-function/description/

class Solution {
    public int maxRotateFunction(int[] nums) {
        //refer copy for the explanation
        //basically its a formula that i created

        int sum = 0;
        int f = 0;
        int n = nums.length;

        for( int i=0; i<n; i++){
            sum+=nums[i];
            f += i*nums[i];
        }

        int max = f;
        //traverse backwards
        for(int i=n-1; i>0; i--){
            max = Math.max(max, f + sum - (n*nums[i]));
            f = f + sum - (n*nums[i]);
        }

        return max;
    }
}
