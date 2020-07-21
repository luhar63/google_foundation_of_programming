import java.util.*;

public class Solution {
  public Map<String, Integer> wordLen(String[] strings) {
    Map<String, Integer> res = new HashMap<String, Integer>();
    for(String s: strings){
      if(res.containsKey(s))
        continue;
      res.put(s, s.length());
    }
    return res;
  }

    public static void main(String[] arg) {
        Solution solution = new Solution();
        // int[] numbers = { 1, 3, 2 };
        String[] strings = {"this", "and", "that", "and"};
        System.out.println(solution.wordLen(strings));
    }
}