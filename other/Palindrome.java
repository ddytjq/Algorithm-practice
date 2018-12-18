import java.util.Scanner;

public class Palindrome
{
    public static int solution(String s)
    {
        int max_len = 1;
        int temp_len = 1;
        int len = s.length();
        for(int i=0; i<len-1; i++){
            if(s.charAt(i) == s.charAt(i+1)){
                temp_len = 0;
                for(int j=i+1; j<len; j++){
                    try{
                        char left = s.charAt(i+1-j+i);
                        char right = s.charAt(j);
                        if(left == right){
                            temp_len += 2;
                        }else{
                            break;
                        }
                    }catch(Exception e){
                        break;
                    }
                }
            }
            if(max_len < temp_len){
                max_len = temp_len;
            }
        }
        
        for(int i=0; i<len-1; i++){
            temp_len = 1;
            for(int j=i-1; j>=0; j--){
                try{
                    char left = s.charAt(j);
                    char right = s.charAt(i+i-j); 
                    if(left == right){
                        temp_len += 2;
                    }else{
                        break;
                    }
                }catch(Exception e){
                    break;
                }
            }
            if(max_len < temp_len){
                max_len = temp_len;
            }
        }
        return max_len;
    }
    
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	String result = sc.next();
    	System.out.println(solution(result));
    }
}