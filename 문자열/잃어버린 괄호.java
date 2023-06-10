import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제 : 실버 2 - 잃어버린 괄호 (1541)
 * 메모리 : 14264 KB
 * 시간 : 128 ms
 * */
public class 잃어버린 괄호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));

        // 식 입력(ex. 55-50+40)
        String s = br.readLine();

        // -를 기준으로 분리
        StringTokenizer minus = new StringTokenizer(s, "-");

        int sum = Integer.MAX_VALUE;

        while(minus.hasMoreTokens()){
            int temp = 0;

            // +를 기준으로 분리
            StringTokenizer plus = new StringTokenizer(minus.nextToken(), "+");

            // +를 먼저 계산
            while(plus.hasMoreTokens()){
                temp += Integer.parseInt(plus.nextToken());
            }

            // 첫 시작은 숫자이기 때문에 -해서 계산하면 안됨
            if(sum==Integer.MAX_VALUE)
                sum = temp;
            else
                sum -= temp;

        }

        bw.write(sum+"");
        bw.flush();

        bw.close();
        br.close();
    }
}

