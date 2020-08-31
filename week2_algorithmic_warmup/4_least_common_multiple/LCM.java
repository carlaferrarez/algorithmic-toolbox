import java.util.Scanner;

public class LCM {
  private static long lcm_naive(Long a, Long b) {
    return (long) ((a * b) / gcd_naive(a, b));
  }

  private static Long gcd_naive(final Long a, final Long b) {
    if (b == 0)
      return (long) a;

    if (b > a) {
      return gcd_naive(b, a);
    }

    Long tempA = b;
    Long tempB = a % b;

    while (tempB != 0) {
      Long aux = tempA;
      tempA = tempB;
      tempB = aux % tempB;
    }

    return (long) tempA;
  }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    Long a = scanner.nextLong();
    Long b = scanner.nextLong();

    System.out.println(lcm_naive(a, b));
    scanner.close();
  }
}
