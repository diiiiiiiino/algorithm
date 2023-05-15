package 자바코딩인터뷰완벽가이드.재귀및동적프로그래밍.로봇격자지도;

class Solution {
    public static long solution(int r1, int r2) {
        long answer = 0;
 
        
        long r1x = (long)Math.pow(r1,2);
        long r2x = (long)Math.pow(r2,2);
        
        //y^2= r^2-x^2
        
        long y1sum=0;
        long y2sum=0;
        long side =0;
        
        for(long i=0;i<=r2;i++){
           
          
           long y2 = (long)Math.sqrt(r2x-(long)Math.pow(i,2));
        
           long y1 = (long)Math.sqrt(r1x-(long)Math.pow(i,2));
            
           // 이 부분 추가!
           if(Math.sqrt((r1x-Math.pow(i,2)))%1==0){
               side++;
           }
          
            answer+=(y2-y1)*4;
        }
      
        answer+=side*4-4;
        
  
        
        return answer;
    }

    public static void main(String[] args) {
        solution(2, 3);
    }
}
