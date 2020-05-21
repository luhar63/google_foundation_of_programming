public class Solution{
    public int sumNumbers(String str) {
    int res = 0;
    int right = 0;
    int num = 0;
    while(right < str.length()){
        char c = str.charAt(right);
        if(c >= '0' && c <= '9') {
        num = num * 10 + (c - '0');
        } else {
        res += num;
        num = 0;
        }
        right++;
    }
    if( num != 0){
        res += num;
    }
    return res;
    }
    public static void main(String[] arg){
        Solution solution = new Solution();
        System.out.println(solution.sumNumbers("abc123xyz"));
    }
}
