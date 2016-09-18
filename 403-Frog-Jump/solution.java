public class Solution {
    public boolean canCross(int[] stones) {
        if(stones[1] > 1) return false;
        if(stones.length == 2) return true;
        return helper(stones, 1, 1);
    }
    private boolean helper(int[] arr, int i, int step){
        boolean pass = false;
        if(i == arr.length-1) return true;
        for(int j = i+1; j < arr.length; j++){
            if(arr[j] <= arr[i] + step + 1 && arr[j] >= arr[i]+step-1){
                pass = pass || helper(arr, j, arr[j] - arr[i]);
            }
        }
        return pass;
    }
}