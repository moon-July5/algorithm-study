import java.io.*;
import java.util.*;

/**
 * 문제 : 실버 4 - 요세푸스 문제(1158)
 * 메모리 : 16392 KB
 * 시간 : 288 ms
 * */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // n명의 사람
        int k = Integer.parseInt(st.nextToken()); // k번째 제거

        // 1 ~ n까지 번호 저장
        Queue<Integer> input = new ArrayDeque<>();
        for(int i=1; i<=n; i++){
            input.add(i);
        }

        bw.write("<");
        while(!input.isEmpty()){
            // k번째가 앞에 위치할 때까지 가장 앞에 있는 값을 빼서 다시 삽입
            for(int i=0; i<k-1; i++){
                input.add(input.poll());
            }
            // 남은 개수가 마지막이 아니면
            if(input.size()!=1){
                bw.write(input.poll()+", ");
            } else {
                bw.write(input.poll()+">");
            }
        }

        bw.flush();

        bw.close();
        br.close();
    }
}

