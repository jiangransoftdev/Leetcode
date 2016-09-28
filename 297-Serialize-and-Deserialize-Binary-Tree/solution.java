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
        helper(root,sb);
        return sb.toString();
    }
    public void helper(TreeNode root,StringBuilder sb){
        if(root==null){
            sb.append("null,");
            return;
        } 
        sb.append(root.val+",");
        helper(root.left,sb);
        helper(root.right,sb);
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strs=data.split(",");
        int[] i=new int[1];
        return dhelper(strs,i);
    }
    public TreeNode dhelper(String[] data,int[] i){
        if(data[i[0]].equals("null")){
            i[0]++;
            return null;
        }
        TreeNode root=new TreeNode(Integer.parseInt(data[i[0]++]));
        TreeNode left=dhelper(data,i);
        TreeNode right=dhelper(data,i);
        root.left=left;
        root.right=right;
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));