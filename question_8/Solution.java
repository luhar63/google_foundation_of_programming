import java.util.ArrayList;

public class Solution {
    public int interpret(int value, String[] commands, int[] args) {
        if(commands.length != args.length) {
          return -1;
        }
        int res = value;
        for(int i=0;i<commands.length;i++){
          if(commands[i].equals("+")){
            res += args[i];
          } else if (commands[i].equals("-")){
            res -= args[i];
          }else if(commands[i].equals("*")) {
            res *= args[i];
          } else{
            res = -1;
            return res;
          }
        }
        return res;
    }

    public static void main(String[] arg) {
        Solution solution = new Solution();
        int[] numbers = { 1, 3, 2 };
        String[] operator = {"+", "*", "-"};
        System.out.println(solution.interpret(1, operator, numbers));
    }
}