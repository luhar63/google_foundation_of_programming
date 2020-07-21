import java.util.*;

public class Solution {
  public String[] encoder(String[] raw, String[] code_words) {
    Map<String, String> map = new HashMap<String, String>();
    int i=0, j=0;
    while(i < raw.length){
      if(!map.containsKey(raw[i])){
        map.put(raw[i], code_words[j]);
        j++;
      }
      i++;
    }
    String[] res = new String[raw.length];
    for(int k = 0; k < raw.length; k++){
      res[k] = map.get(raw[k]);
    }
    return res;
  }

  public static void main(String[] arg) {
      Solution solution = new Solution();
      // int[] numbers = { 1, 3, 2 }
      String[] raw = {"a", "b", "a"};
      String[] codes = {"1", "2", "3", "4"};
      System.out.println(solution.encoder(raw, codes));
  }
}