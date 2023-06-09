import java.io.*;
import java.util.*;

/**
 * 문제 : 실버 2 - 쇠막대기 (10799)
 * 메모리 : 16364 KB
 * 시간 : 188 ms
 * */
public class 쇠막대기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));

        // 쇠막대기와 레이저의 배치를 나타내는 괄호 표현 입력(ex. ()(((()())(())()))(()) )
        String s = br.readLine();

        Stack<Character> stack = new Stack<>();

        int answer = 0;

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='(') // 여는 괄호일 경우,
                stack.add(s.charAt(i)); // 스택에 저장
            else { // 닫는 괄호일 경우,
                stack.pop();

                if(s.charAt(i-1)=='('){ // 이전 괄호가 여는 괄호일 경우(레이저일 경우),
                    answer += stack.size(); // 스택에 있는 사이즈만큼 개수 저장
                } else {
                    answer++;
                }
            }
        }

        bw.write(answer+"");
        bw.flush();

        bw.close();
        br.close();
    }
}

