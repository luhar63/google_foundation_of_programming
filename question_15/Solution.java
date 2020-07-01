import java.util.*;

public class Solution {
  public boolean evenlySpaced(int a, int b, int c) {
    if(a > b){
      int temp = b;
      b =a;
      a=temp;
    }
    if(b > c){
      int temp = b;
      b = c;
      c = temp;
    }
    if(a > b){
      int temp = b;
      b =a;
      a=temp;
    }
    return 2*b == (a+c);
  }
  

  public static void main(String[] arg) {
      Solution solution = new Solution();
      // int[] numbers = { 1, 3, 2 }
      // String[] raw = {"a", "b", "a"};
      // String[] codes = {"1", "2", "3", "4"};
      System.out.println(solution.evenlySpaced(4, 6, 2));
  }
}