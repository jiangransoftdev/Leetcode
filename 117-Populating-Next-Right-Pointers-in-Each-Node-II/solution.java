/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        TreeLinkNode dummy=new TreeLinkNode(0);
        TreeLinkNode prev=dummy;
        while(root!=null){
            if(root.left!=null){
                prev.next=root.left;
                prev=prev.next;
            }
            if(root.right!=null){
                prev.next=root.right;
                prev=prev.next;
            }
            root=root.next;
            if(root==null){
                prev=dummy;
                root=prev.next;
                dummy.next=null;
            }
        }
    }
}