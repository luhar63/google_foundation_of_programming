import java.util.*;

public class Solution {
  public Map<String, String> pairs(String[] strings) {
    Map<String, String> res = new HashMap<String, String>();
    for(String s: strings){
      res.put(String.valueOf(s.charAt(0)), String.valueOf(s.charAt(s.length()-1)));
    }
    return res;
  }

    public static void main(String[] arg) {
        Solution solution = new Solution();
        // int[] numbers = { 1, 3, 2 };
        String[] strings = {"man", "moon", "good", "night"};
        System.out.println(solution.pairs(strings));
    }
}