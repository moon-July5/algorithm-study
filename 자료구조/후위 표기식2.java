import java.io.*;
import java.util.*;

/**
 * 문제 : 실버 3 - 후위 표기식2 (1935)
 * 메모리 : 14660 KB
 * 시간 : 136 ms
 * */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));

        // 피연산자 개수
        int n = Integer.parseInt(br.readLine());
        // 후위 표기식(ex. ABC*+DE/-)
        String s = br.readLine();

        double[] value = new double[n];
        // 피연산자에 대응하는 값 입력
        for(int i=0; i<n; i++){
            value[i] = Double.parseDouble(br.readLine());
        }

        // 피연산자 저장
        Stack<Double> operand = new Stack<>();

        for(int i=0; i<s.length(); i++){
            // 연산자가 아니면
            if(s.charAt(i)!='+' && s.charAt(i)!='-' && s.charAt(i)!='/' && s.charAt(i)!='*'){
                operand.add(value[s.charAt(i)-'A']);
            } else { // 연산자 일 경우
                // 연산을 위해 스택에 저장된 피연산자 2개를 꺼냄
                double value1 = operand.pop(); 
                double value2 = operand.pop();

                // 연산자에 따라서 계산
                if(s.charAt(i)=='+'){
                    operand.add(value1+value2);
                } else if(s.charAt(i)=='-'){
                    operand.add(value2-value1);
                } else if(s.charAt(i)=='*'){
                    operand.add(value1*value2);
                } else if(s.charAt(i)=='/'){
                    operand.add(value2/value1);
                }
            }
        }

        // 소수점 두 자리 출력
        bw.write(String.format("%.2f",operand.pop()));
        bw.flush();

        bw.close();
        br.close();
    }
}

