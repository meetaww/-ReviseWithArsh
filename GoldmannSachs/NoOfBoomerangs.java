//Solved on Leetcode : https://leetcode.com/problems/number-of-boomerangs/description/

class Solution {
    public int numberOfBoomerangs(int[][] points) {
       int count=0;

       

       for( int i=0; i<points.length; i++){
           Map<Long, Integer> map = new HashMap<Long, Integer>();
           for( int j=0; j<points.length; j++){
                long x1 = (long)(points[i][0]);
                long y1 = (long)(points[j][0]);
                long x2 = (long)(points[i][1]);
                long y2 = (long)(points[j][1]);

                long dist = (x1-y1)*(x1-y1) + (x2-y2)*(x2-y2);
                map.put(dist, map.getOrDefault(dist, 0)+1);

           }

           for( int v: map.values())
                count += v*(v-1);
       }
        return count;

    }
}
