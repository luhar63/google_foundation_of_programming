public class Solution{
    public String withoutString(String base, String remove) {
    int bi = 0;
    int blen = base.length();
    int rlen = remove.length();
    String baselow = base.toLowerCase();
    String removelow = remove.toLowerCase();
    String ss = "";
    while(bi < blen){
        if((bi+rlen <= blen) && baselow.substring(bi, bi+rlen).equals(removelow)){
        // if(baselow.charAt(bi)==removelow.charAt(ri)) {
        // while(ri<remove.length() && baselow.charAt(ci)==removelow.charAt(ri)) {
        //   counter++;
        //   ri++;
        //   ci++;
        // }
        // if(counter==rlen){
        //   bi+=counter;
        // }
        bi+=rlen;
        } else {
        ss+= base.charAt(bi);
        bi++;
        }
    }
    return ss.toString();
    }
    public static void main(String[] arg){
        Solution solution = new Solution();
        System.out.println(solution.withoutString("Hello there", "llo"));
    }
}

