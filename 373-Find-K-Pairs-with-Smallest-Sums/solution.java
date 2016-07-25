public class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
List<int[]> res=new ArrayList<>();
        if(k==0) return res;
        PriorityQueue<int[]> pq=new PriorityQueue( new Comparator<int[]>(){
            public int compare(int[] a,int[] b){
                return a[0]+a[1]-b[0]-b[1];
                }
            });
        for(int i=0;i<nums1.length;i++){
        	for(int j=0;j<nums2.length;j++){
        		int[] a=new int[2];
        		a[0]=nums1[i];
        		a[1]=nums2[j];
        		pq.offer(a);
        	}
        }
        for(int i=0;i<k;i++){
            if(pq.size()==0) break;
        	res.add(pq.poll());
        }
        return res;
    }
}