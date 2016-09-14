public class NumArray {
    int[] tree;
    int[] nums;
    public NumArray(int[] nums) {
        this.nums=nums;
        tree=new int[nums.length+1];
        for(int i=0;i<nums.length;i++)
            buildTree(tree,i+1);
    }
    public void buildTree(int[] tree,int i){
        int val=nums[i-1];
        while(i<tree.length){
            tree[i]+=val;
            i+=i&-i;
        }
    }
    public void update(int i, int val) {
        int diff=val-nums[i];
        nums[i]=val;
        i++;
        while(i<tree.length){
            tree[i]+=diff;
            i+=i&-i;
        }
    }
    public int get(int i){
        int sum=0;
        while(i>0){
            sum+=tree[i];
            i-=i&-i;
        }
        return sum;
    }
    public int sumRange(int i, int j) {
        return get(j+1)-get(i);
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.update(1, 10);
// numArray.sumRange(1, 2);