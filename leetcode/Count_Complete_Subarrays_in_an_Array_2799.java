// File: Solution.java

import java.util.*;

class Solution {
    public int countCompleteSubarrays(int[] a) {
        int n = a.length, r = 0, l = 0, out = 0;
        Set<Integer> d = new HashSet<>();
        for (int x : a) d.add(x);
        int D = d.size();
        Map<Integer, Integer> m = new HashMap<>();
        for (; r < n; r++) {
            m.put(a[r], m.getOrDefault(a[r], 0) + 1);
            while (m.size() == D) {
                out += n - r;
                m.put(a[l], m.get(a[l]) - 1);
                if (m.get(a[l]) == 0) m.remove(a[l]);
                l++;
            }
        }
        return out;
    }
}
