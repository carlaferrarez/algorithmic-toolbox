import java.util.Scanner;

public class FractionalKnapsack {
    private static double getOptimalValue(int capacity, int[] values, int[] weights) {
        double value = 0;
        int arraySize = values.length;
        double[] proportional = new double[arraySize];

        for (int i = 0; i < arraySize; i++) {
            proportional[i] = (double) values[i] / weights[i];
        }

        reorder(values, weights, proportional);

        for (int j = 0; j < arraySize; j++) {

            if (capacity >= weights[j]) {

                double tempValue = values[j];
                capacity = capacity - weights[j];
                value = value + tempValue;
            }

            else {

                double y = (double) capacity * proportional[j];
                value = value + (double) Math.round(y * 10000.0) / 10000.0;
                capacity = capacity - weights[j];

                if (capacity <= 0)
                    break;
            }
        }

        return value;
    }

    static void reorder(int[] values, int[] weights, double[] proportional) {
        for (int i = 1; i < values.length; i++) {
            for (int j = i; j > 0; j--) {
                
                if (proportional[j] > proportional[j - 1]) {
                    double tempB = proportional[j];
                    int tempV = values[j];
                    int tempW = weights[j];
                    proportional[j] = proportional[j - 1];
                    proportional[j - 1] = tempB;
                    values[j] = values[j - 1];
                    values[j - 1] = tempV;
                    weights[j] = weights[j - 1];
                    weights[j - 1] = tempW;
                }
            }
        }
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        System.out.println(getOptimalValue(capacity, values, weights));
        scanner.close();
    }
}
