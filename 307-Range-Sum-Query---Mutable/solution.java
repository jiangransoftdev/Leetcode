public class NumArray {
    int[] tree,nums;
    public NumArray(int[] nums) {
        this.nums=nums;
        tree=new int[nums.length+1];
        for(int i=0;i<nums.length;i++)
            build(i+1,nums[i]);
    }
    void build(int i,int val){
        while(i<tree.length){
            tree[i]+=val;
            i+=i&-i;
        }
    }
    void update(int i, int val) {
        int diff=val-nums[i];
        nums[i]=val;
        build(i+1,diff);
    }
    int sum(int i){
        i++;
        int sum=0;
        while(i>0){
            sum+=tree[i];
            i-=i&-i;
        }
        return sum;
    }
    public int sumRange(int i, int j) {
        return sum(j)-sum(i-1);
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.update(1, 10);
// numArray.sumRange(1, 2);