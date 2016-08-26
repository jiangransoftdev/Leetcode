/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb=new StringBuilder();
        shelper(root,sb);
        return sb.toString();
    }
    public void shelper(TreeNode root,StringBuilder sb){
        if(root==null){
            sb.append("null ");
            return;
        }
        sb.append(root.val+" ");
        shelper(root.left,sb);
        shelper(root.right,sb);
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] sdata=data.split(" ");
        int[] index=new int[1];
        return dhelper(sdata,index);
    }
    public TreeNode dhelper(String[] data,int[] index){
        String s=data[index[0]++];
        if(s.equals("null")) return null;
        TreeNode root=new TreeNode(Integer.parseInt(s));
        root.left=dhelper(data,index);
        root.right=dhelper(data,index);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));