import java.util.Scanner;

public class DotProduct {
    private static long maxDotProduct(long[] a, long[] b) {
        long result = 0;

        reorder(a);
        reorder(b);

        for (int i = 0; i < a.length; i++) {
            result += a[i] * b[i];
        }
        return result;
    }

    private static void reorder(long[] array) {
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0; j--) {
                if (array[j] > array[j - 1]) {
                    long tempB = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = tempB;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        long[] b = new long[n];
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
        }
        System.out.println(maxDotProduct(a, b));
        scanner.close();
    }
}
