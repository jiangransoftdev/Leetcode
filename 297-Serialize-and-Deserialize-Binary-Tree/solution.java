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
    int index=0;
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
        sb.append(String.valueOf(root.val));
        sb.append(" ");
        shelper(root.left,sb);
        shelper(root.right,sb);
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] spdata=data.split(" ");
        int[] index=new int[1];
        return dhelper(spdata,index);
    }
    public TreeNode dhelper(String[] data,int[] i){
        String s=data[i[0]++];
        if(s.equals("null")) return null;
        TreeNode node=new TreeNode(Integer.valueOf(s));
        node.left=dhelper(data,i);
        node.right=dhelper(data,i);
        return node;
    }
    
    
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));