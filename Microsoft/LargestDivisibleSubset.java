//SOlved on Leetcode : https://leetcode.com/problems/largest-divisible-subset/

class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length; 
        //if the array is null
        if(n==0){
            return new ArrayList();
        }

        //first we sort the array
        Arrays.sort(nums);

        //now we need to find the longest increasing subsequence
        int dp[] = new int [n];
        Arrays.fill(dp, 1);     //since each element is also a longest inc seq.

        int max = 1;
        for(int i=1; i<n; i++){
            for( int j=0; j<i; j++){        //LIS logic
                if(nums[i]%nums[j]==0 && 1+dp[j]>dp[i]){
                    dp[i] = 1+dp[j];

                    if(max<dp[i]){
                        max = dp[i];        //update the max value alongwise
                    }
                }
            }
        }

        //iterating from right to left to find the subset
        List<Integer> list = new LinkedList<>();
        int prev=-1;        //intialized as -1 because it maybe at the first index at some time and that might throw an error, since it has no prev value

        for( int i=n-1; i>=0; i--){
            if(dp[i]==max && (prev%nums[i]==0 || prev==-1)){ //if prev=-1 that means you are at the first element

                list.add(nums[i]);
                max-=1;
                prev = nums[i];     // so that we can compare the corresponding values if they are divisible or not

            }
        }

        return list;
    }
}
