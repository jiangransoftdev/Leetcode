public class Solution {
    public int minTotalDistance(int[][] grid) {
        List<Integer> x=new ArrayList<>();
        List<Integer> y=new ArrayList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    x.add(i);
                    y.add(j);
                }
            }
        }
        int sum=0;
        for(int xpos:x)
            sum+=Math.abs(xpos-x.get(x.size()/2));
        Collections.sort(y);
        for(int ypos:y)
            sum+=Math.abs(ypos-y.get(y.size()/2));
        return sum;
    }
}