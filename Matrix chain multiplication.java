import java.util.*;

public class Main {

    public static int matrixChainMultiplication(int[] p) {
        int n = p.length - 1;
        int[][] dp = new int[n][n];

        for (int length = 2; length <= n; length++) {
            for (int i = 0; i < n - length + 1; i++) {
                int j = i + length - 1;
                dp[i][j] = Integer.MAX_VALUE;

                for (int k = i; k < j; k++) {
                    int cost = dp[i][k] + dp[k + 1][j]
                            + p[i] * p[k + 1] * p[j + 1];

                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }

        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of matrices: ");
        int n = sc.nextInt();

        int[] dimensions = new int[n + 1];

        System.out.println("Enter dimensions:");
        for (int i = 0; i <= n; i++) {
            dimensions[i] = sc.nextInt();
        }

        int result = matrixChainMultiplication(dimensions);

        System.out.println("Minimum number of multiplications: " + result);

        sc.close();
    }
}
