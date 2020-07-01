import java.util.*;

public class Solution {
  public int blackjack(int a, int b) {
    int i = 21 - a;
    int j = 21 - b;
    if ( i >=0 && j >= 0 ){
      if(i<j){
        return a;
      }else{
        return b;
      }
    }
    if( i>=0){
      return a;
    }
    if(j >= 0){
      return b;
    }
    return 0;
  }

  public static void main(String[] arg) {
      Solution solution = new Solution();
      // int[] numbers = { 1, 3, 2 }
      // String[] raw = {"a", "b", "a"};
      // String[] codes = {"1", "2", "3", "4"};
      System.out.println(solution.blackjack(21, 22));
  }
}