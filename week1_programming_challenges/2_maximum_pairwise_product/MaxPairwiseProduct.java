import java.util.*;
import java.util.stream.IntStream;
import java.io.*;

public class MaxPairwiseProduct {
    static long getMaxPairwiseProduct(long[] numbers) {
        long first_number = 0;
        long second_number = 0;
        int n = numbers.length;

        for (int first = 0; first < n; ++first) {
            first_number = Math.max(first_number, numbers[first]);
        }

        long first_number_index = IndexOf(numbers, first_number);

        for (int first = 0; first < n; ++first) {
            if (first != first_number_index){
                second_number = Math.max(second_number, numbers[first]);    
            }   
        }

        return first_number * second_number;
    }

    static long IndexOf (long[] numbers, long index_number){
        return IntStream.range(0, numbers.length)
                        .filter(i -> index_number == numbers [i])
                        .findFirst()
                        .orElse(-1);
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        long[] numbers = new long[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        System.out.println(getMaxPairwiseProduct(numbers));
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new
                    InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

}
