import java.util.Scanner;

public class ChangeDP {

    private static int getChange(int m) {

        int[] minNumCoins = new int[m + 1];       
        int[] coins = {4, 3, 1};

        for (int i = 1; i <= m; i++) {
            minNumCoins[i] = Integer.MAX_VALUE;
            int res = Integer.MAX_VALUE;

            for (int c : coins) {
                if (i - c >= 0) {
                    res = minNumCoins[i - c];
                }

                if (res != Integer.MAX_VALUE) {
                    minNumCoins[i] = Integer.min(minNumCoins[i], res + 1);
                }
            }
        }

        return minNumCoins[m];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));
        scanner.close();

    }
}

