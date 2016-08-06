public class Solution {
    public enum InputType{
	INVALID,    // 0
	SPACE,      // 1
    SIGN,       // 2
	DIGIT,      // 3
	DOT,        // 4
	EXPONENT,   // 5
	NUM_INPUTS  // 6
};
    public boolean isNumber(String s) {
        int[][] trans={{-1,  0,  3,  1,  2, -1},{-1,  8, -1,  1,  4,  5},
			{-1, -1, -1,  4, -1, -1},{-1, -1, -1,  1,  2, -1},{-1,  8, -1,  4, -1,  5},
			{-1, -1,  6,  7, -1, -1},{-1, -1, -1,  7, -1, -1},{-1,  8, -1,  7, -1, -1},
			{-1,  8, -1, -1, -1, -1}};
	int state=0;
	int i=0;
	while(i<s.length()){
		InputType input=InputType.INVALID;
		if(s.charAt(i)==' ')
			input=InputType.SPACE;
		else if(s.charAt(i)=='+'||s.charAt(i)=='-')
			input=InputType.SIGN;
		else if(s.charAt(i)=='.')
			input=InputType.DOT;
		else if(s.charAt(i)=='e'||s.charAt(i)=='E')
			input=InputType.EXPONENT;
		else if(s.charAt(i)>='0'&&s.charAt(i)<='9')
			input=InputType.DIGIT;
		state=trans[state][input.ordinal()];
		if(state==-1) return false;
		else i++;
	}
	return state==1||state==4||state==7||state==8;
    }
}