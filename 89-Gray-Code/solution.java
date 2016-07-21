public class Solution {
    public List<Integer> res = new ArrayList<Integer>();

public List<Integer> grayCode(int n) {
	int[] a = new int[n];
	if (n == 0) {
		res.add(0);
		return res;
	}
	cal(0, a, n);
	return res;
}

private void cal(int index, int[] bits, int n) {
	if (index == n) {
		int sum = 0;
		sum += bits[0] * (1 << n - 1);
		for (int i = 1; i < n; i++) {
			sum += (bits[i] ^ bits[i - 1]) * (1 << (n - i - 1));
		}
		res.add(sum);
	} else {
		bits[index] = 0;
		cal(index + 1, bits, n);
		bits[index] = 1;
		cal(index + 1, bits, n);
	}
}
}