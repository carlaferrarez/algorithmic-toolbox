import java.util.Scanner;

public class GCD {
  private static int gcd_naive(final int a, final int b) {

    if (b == 0)
      return a;

    if (b > a) {
      return gcd_naive(b, a);
    }

    int tempA = b;
    int tempB = a % b;

    while (tempB != 0) {
      int aux = tempA;
      tempA = tempB;
      tempB = aux % tempB;
    }

    return tempA;
  }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();

    System.out.println(gcd_naive(a, b));
    scanner.close();
  }
}
