import java.util.Scanner;

public class Change {
    private static int getChange(int m) {
        // write your code here
        int numOperacoes = 0;

        if (m / 10 > 0) {
            numOperacoes = m / 10;
            m = m % 10;
        }

        if (m / 5 > 0) {
            numOperacoes = (m / 5) + numOperacoes;
            m = m % 5;
        }

        if (m / 1 > 0) {
            numOperacoes = m + numOperacoes;
        }

        return numOperacoes;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));
        scanner.close();

    }
}
