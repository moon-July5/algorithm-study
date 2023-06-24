import java.io.*;
import java.util.*;

/**
 * 문제 : 실버 2 - 좌표 압축 (18870)
 * 메모리 : 270588 KB
 * 시간 : 1912 ms
 * */
public class 좌표 압축 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));

        int n = Integer.parseInt(br.readLine());

        int[] input = new int[n];
        int[] sorted = new int[n];

        // 좌표 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            int value = Integer.parseInt(st.nextToken());
            input[i] = sorted[i] = value;
        }

        // 정렬
        Arrays.sort(sorted);

        HashMap<Integer, Integer> hashMap = new HashMap<>();

        int count = 0;

        for(int value : sorted){
            if(!hashMap.containsKey(value)){
                hashMap.put(value, count);
                count++;
            }
        }

        for(int value : input){
            bw.write(hashMap.get(value)+" ");
        }
        bw.flush();

        bw.close();
        br.close();
    }

}

