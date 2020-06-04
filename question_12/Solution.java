import java.util.*;

public class Solution {
  public Map<String, Integer> wordCount(String[] strings) {
    Map<String, Integer> res = new HashMap<String, Integer>();
    for(String s: strings){
      res.put(s, res.getOrDefault(s, 0)+1);
    }
    return res;
  }

  public static void main(String[] arg) {
      Solution solution = new Solution();
      // int[] numbers = { 1, 3, 2 };
      String[] strings = {"a", "b", "a", "c", "b"};
      System.out.println(solution.wordCount(strings));
  }
}