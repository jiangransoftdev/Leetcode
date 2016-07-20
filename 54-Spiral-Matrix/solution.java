public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res=new ArrayList<Integer>();
        if(matrix.length==0) return res;
        spiralMatrix(matrix,0,matrix[0].length,matrix.length,res);
        return res;
    }
    public void spiralMatrix(int[][] matrix,int offside,int msize,int nsize,List<Integer> res){
	if(nsize<=1){
		for(int i=0;i<msize&&nsize==1;i++)
			res.add(matrix[offside][offside+i]);
		return;
	}
	if(msize<=1){
		for(int i=0;i<nsize&&msize==1;i++)
			res.add(matrix[offside+i][offside]);
		return;
	}
	for(int i=0;i<msize;i++)
		res.add(matrix[offside][offside+i]);
	for(int j=1;j<nsize-1;j++)
		res.add(matrix[offside+j][offside+msize-1]);
	for(int k=0;k<msize;k++){
		res.add(matrix[offside+nsize-1][offside+msize-1-k]);
	}
	for(int m=1;m<nsize-1;m++){
		res.add(matrix[offside+nsize-1-m][offside]);
	}
	spiralMatrix(matrix,offside+1,msize-2,nsize-2,res);
}
}