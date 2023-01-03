//Solved on Leetcode : https://leetcode.com/problems/combination-sum-iii/description/

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        //to store the result -list<list>
        List<List<Integer>> res = new ArrayList();
        //our helper function to carry out the actual operation of the question
        findSum(1, 9, k, n, new LinkedList(), res);        //here 1 is the index to start from and 9 is the end index

        return res;

    }
    void findSum(int start, int end, int k, int n, LinkedList ll, List<List<Integer>> res){
       

        if(k==ll.size() && n==0){
            res.add(new ArrayList(ll));
            return;
        }

        for( int i=start; i<=end; i++){
            ll.add(i);          //we add the element one by one n check if they add upto n or not
            findSum(i+1, end, k, n-i, ll, res);
            ll.remove(ll.size() -1);    //we remove the latest element from the array if we see that they do not add upto the given number ; BACKTRACKING
        }
    }
}
