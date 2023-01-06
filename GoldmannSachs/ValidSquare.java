//Solved on Leetcode : https://leetcode.com/problems/valid-square/

class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        //diagonal is root(2)*a
        //all sides are equal but since we do not know the order of the points provided, we make an array n store the distances of each and then compare if 4 sides are equal and 2 diagonals are equal or not

        int[] arr = new int[6];
        arr[0] = (int)Math.pow(p1[0] - p2[0],2) + (int)Math.pow(p1[1] - p2[1], 2);
        arr[1] = (int)Math.pow(p1[0] - p3[0],2) + (int)Math.pow(p1[1] - p3[1], 2);
        arr[2] = (int)Math.pow(p1[0] - p4[0],2) + (int)Math.pow(p1[1] - p4[1], 2);
        arr[3] = (int)Math.pow(p2[0] - p3[0],2) + (int)Math.pow(p2[1] - p3[1], 2);
        arr[4] = (int)Math.pow(p2[0] - p4[0],2) + (int)Math.pow(p2[1] - p4[1], 2);
        arr[5] = (int)Math.pow(p3[0] - p4[0],2) + (int)Math.pow(p3[1] - p4[1], 2);

        int min = arr[0];
        for (int i=0; i<6; i++){
            if(min>arr[i])
                min = arr[i];
        }
        int side = 0, diag =0;
        for( int i=0; i<6; i++){
            if(min==arr[i])
                side++;
            else if(arr[i] == 2*min)
                    diag++;

        }

        return (side==4)&&(diag==2);
    }
}
