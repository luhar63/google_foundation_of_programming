import java.util.ArrayList;

public class Solution {
    public int[] sort(int[] a) {
        ArrayList<Integer> ar = new ArrayList<Integer>();
        if (a.length == 0) {
            return new int[0];
        }
        // Arrays.sort(a);
        ar.add(a[0]);
        for (int i = 1; i < a.length; i++) {
            if (a[i - 1] == a[i]) {
                continue;
            } else {
                ar.add(a[i]);
            }
        }
        int[] res = new int[ar.size()];
        int i = 0;
        for (Integer ls : ar) {
            res[i++] = ls;
        }
        return res;
    }

    public static void main(String[] arg) {
        Solution solution = new Solution();
        int[] array = { 1,1,2 };
        for(int i: solution.sort(array)){
            System.out.print(i + " ");
        }
        System.out.println();
    }
}