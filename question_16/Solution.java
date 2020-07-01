import java.util.*;

public class Solution {
  public boolean makeBricks(int small, int big, int goal) {
    if(goal/5 >= big){
      if(big*5 + small >= goal){
        return true;
      } else{
        return false;
      }
    } else{
      if((goal/5)*5 + small >= goal){
        return true;
      }else{
        return false;
      }
    }
  }
  
  

  public static void main(String[] arg) {
      Solution solution = new Solution();
      // int[] numbers = { 1, 3, 2 }
      // String[] raw = {"a", "b", "a"};
      // String[] codes = {"1", "2", "3", "4"};
      System.out.println(solution.makeBricks(6, 0, 11));
  }
}