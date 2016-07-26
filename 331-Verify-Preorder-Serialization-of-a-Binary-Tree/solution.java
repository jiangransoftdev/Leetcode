public class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] s=preorder.split(",");
        int diff=1;
        for(String str:s){
            if(--diff<0) return false;
            if(!str.equals("#")) diff+=2;
        }
        return diff==0;
    }
}