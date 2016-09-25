public class Solution {
    public int[][] reconstructQueue(int[][] people) {
        int[][] res=new int[people.length][2];
        Arrays.sort(people,new Comparator<int[]>(){
            public int compare(int[] a,int[] b){
                if(a[0]==b[0]) return a[1]-b[1];
                return b[0]-a[0];
            }
        });
        ArrayList<int[]> tmp=new ArrayList<>();
        for(int i=0;i<people.length;i++)
            tmp.add(people[i][1],new int[]{people[i][0],people[i][1]});
        int index=0;
        for(int[] i:tmp){
            res[index][0]=i[0];
            res[index++][1]=i[1];
        }
        return res;
    }
}