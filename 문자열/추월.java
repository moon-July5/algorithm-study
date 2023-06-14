import java.io.*;
import java.util.*;

/**
 * 문제 : 실버 1 - 추월 (2002)
 * 메모리 : 14392 KB
 * 시간 : 140 ms
 * */
public class 추월 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));

        // 차의 대수
        int n = Integer.parseInt(br.readLine());

        HashMap<String, Integer> map = new HashMap<>();

        // 차량 이름 입력
        for(int i=0; i<n; i++){
            map.put(br.readLine(), i);
        }

        int[] arr = new int[n];

        // 터널에서 나온 차량 입력받으면서 순서 값 배열로 저장
        for(int i=0; i<n; i++){
            arr[i] = map.get(br.readLine());
        }

        int answer = 0;

        for(int i=0; i<n-1; i++){
            for(int j=i+1; j<n; j++){
                // 추월한 경우
                if(arr[i]>arr[j]) {
                    answer++;
                    break;
                }
            }
        }
        bw.write(answer+"");
        bw.flush();

        bw.close();
        br.close();
    }
}

