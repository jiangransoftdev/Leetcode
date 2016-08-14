public class NumArray {
    int[] tree;
    int[] nums;
    public NumArray(int[] nums) {
        this.nums=nums;
        tree=new int[nums.length+1];
        for(int i=0;i<nums.length;i++)
            add(i+1,nums[i]);
    }
    public void add(int i,int val){
        int n=tree.length;
        while(i<n){
            tree[i]+=val;
            i+=i&-i;
        }
    }
    public int get(int i){
        i++;
        int sum=0;
        while(i>0){
            sum+=tree[i];
            i-=i&-i;
        }
        return sum;
    }
    void update(int i, int val) {
        int diff=val-nums[i];
        nums[i]=val;
        add(i+1,diff);
    }

    public int sumRange(int i, int j) {
        return get(j)-get(i-1);
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.update(1, 10);
// numArray.sumRange(1, 2);