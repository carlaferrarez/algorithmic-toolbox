import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class MajorityElement {
    private static int getMajorityElement(int[] a, int left, int right) {


        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();


        for (int i = 0; i < right; i++) {
            if (map.containsKey(a[i])) {
                int count = map.get(a[i]) + 1;
                if (count> right/2)
                    return a[i];
                else
                    map.put(a[i], count);
            }
            else {
                map.put(a[i], 1);
            }
        }
        return -1;



        // int currentElement;
        // int count = 0;
        // double mid = ((double)(right - left)/2);


        // if (left == right) {
        //     return -1;
        // }

        // if (left + 1 == right) {
        //     return a[left];
        // }


        // for (int i = 0; i < right; i++) {
        //     currentElement = a[i];
        //     count = 0;

        //     for (int j = 0; j < right; j++) {
        //         if (a[j] == currentElement)
        //             count = count + 1;
        //     }

        //     if (count > mid)
        //         return a[i];
        // }
        // return -1;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        if (getMajorityElement(a, 0, a.length) != -1) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
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
