package 자바코딩인터뷰완벽가이드.배열과문자열.동일한문자열만들기;

public class Main {
    public static void main(String[] args) {
        System.out.println(isOneEditAway("tnc", "tank"));
    }

    public static boolean isOneEditAway(String q, String p){
        if(q == null || p == null || q.isBlank() || p.isBlank()){
            return false;
        }

        if(Math.abs(q.length() - p.length()) > 1){
            return false;
        }

        String shorter = q.length() < p.length() ? q : p;
        String longer = q.length() < p.length() ? p : q;

        int is = 0;
        int il = 0;
        boolean marker = false;

        while(is < shorter.length() && il < longer.length()){
            if(shorter.charAt(is) != longer.charAt(il)){
                if(marker){
                    return false;
                }

                marker = true;

                if(shorter.length() == longer.length()){
                    is++;
                }
            } else {
                is++;
            }

            il++;
        }

        return true;
    }
}
