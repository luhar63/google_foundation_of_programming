public class Solution{
    public boolean canBalance(int[] nums) {
        int start = 0;
        int end = 0;
        
        // completely filling up the end
        for(int num: nums){
            end +=num;
        }
        // then start removing from end again fromm start one by one to match 
        // at some point
        for(int num: nums){
            start +=num;
            end -=num;
            if(start == end){
            return true;
            }
        }
        return false;
    }
    public static void main(String[] arg){
        Solution solution = new Solution();
        int[] array = {2, 1, 1, 2, 1};
        System.out.println(solution.canBalance(array));
    }
}