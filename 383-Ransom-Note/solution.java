public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote == null || magazine == null || ransomNote.length() > magazine.length())
return false;

	char[] s1 = ransomNote.toCharArray();
	char[] s2 = magazine.toCharArray();
	
	Arrays.sort(s1);
	Arrays.sort(s2);
	
	int i = 0, j = 0;
	while (j < s2.length && i < s1.length){
		if (s1[i] ==  s2[j]){
			i++;
			j++;
		}
		else if (s1[i] < s2[j]){
			return false;
		}
		else if (s1[i] > s2[j]){
			j++;
		}
	}
	
	return i == s1.length;
    }
}