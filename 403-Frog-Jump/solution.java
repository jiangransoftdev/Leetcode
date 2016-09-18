public class Solution {
    public boolean canCross(int[] stones) {
       final int l = stones != null ? stones.length : 0;
        if (l < 1 || stones[0] != 0) return false;
        final Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int s : stones) map.put(s, new HashSet<Integer>());
        for (int s : stones) {
            Set<Integer> jSet = map.get(s);
            // Initial condition
            if (s == 0) {
                jSet.add(0);
                if (map.containsKey(1)) map.get(1).add(1);
                continue;
            }
            // For other stones
            for (int j : jSet) {
                int jj = j - 1;
                int ss = s + jj;
                // Previous jump - 1
                if (ss != s && map.containsKey(ss)) map.get(ss).add(jj);
                // Previous jump
                jj++; ss++;
                if (ss != s && map.containsKey(ss)) map.get(ss).add(jj);
                // Previous jump + 1
                jj++; ss++;
                if (ss != s && map.containsKey(ss)) map.get(ss).add(jj);
            }
        }
        return !map.get(stones[l - 1]).isEmpty();
    }
}