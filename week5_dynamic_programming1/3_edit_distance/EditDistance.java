import java.util.*;

class EditDistance {
  public static int EditDistance(String s, String t) {

    int sLength = s.length();
    int tLength = t.length();

    int[][] distance = new int[sLength + 1] [tLength + 1];

    for (int i=0; i <= sLength; i++) {
      distance[i][0] = i;
    }

    for (int j=0; j <= tLength; j++) {
      distance[0][j] = j;
    }

    for (int i = 1; i <= sLength; i++) {
      for (int j = 1; j <= tLength; j++) {

        distance[i][j] = Integer.MAX_VALUE;

        if (s.charAt(i-1) == t.charAt(j-1))
          distance[i][j] = distance[i-1][j-1];
        
        int insertion = distance[i][j- 1] + 1;
        int deletion = distance[i - 1][j] + 1;
        int substitution = distance[i - 1][j - 1] + 1;

        distance[i][j] = Math.min(Math.min(Math.min(distance[i][j], substitution), insertion), deletion);

      }
    }
    return distance[sLength][tLength];
  }
  public static void main(String args[]) {
    Scanner scan = new Scanner(System.in);

    String s = scan.next();
    String t = scan.next();

    System.out.println(EditDistance(s, t));
    scan.close();
  }

}
