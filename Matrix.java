
import java.util.*;

public class Matrix {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] M = new int[n][m];
        inputMatrix(M, n, m);
        printMatrix(M, n, m);
        int[][] M_T = transposeMatrix(M, n, m);
        printMatrix(M_T, n, m);
    }

    public static int[][] addMatrix(int[][] M1, int[][] M2) {

        // if ((M1.length != M2.length) || M1[0].length != M2[0].length) {
        //     System.out.println("Order of two matrices should be same.");
        // }
        int n = M1.length;
        int m = M1[0].length;

        int[][] result = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result[i][j] = M1[i][j] + M2[i][j];
            }
        }

        return result;
    }

    public static int[][] subtractMatrix(int[][] M1, int[][] M2) {

        // if ((M1.length != M2.length) || M1[0].length != M2[0].length) {
        //     System.out.println("Order of two matrices should be same.");
        // }
        int n = M1.length;
        int m = M1[0].length;

        int[][] result = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result[i][j] = M1[i][j] - M2[i][j];
            }
        }

        return result;
    }

    public static int[][] transposeMatrix(int[][] M, int n, int m) {

        // if ((M1.length != M2.length) || M1[0].length != M2[0].length) {
        //     System.out.println("Order of two matrices should be same.");
        // }
        int[][] result = new int[m][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result[j][i] = M[i][j];
            }
        }

        return result;
    }

    public static void inputMatrix(int[][] M, int n, int m) {

        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                M[i][j] = sc.nextInt();
            }
        }

    }

    public static void printMatrix(int[][] M, int n, int m) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(M[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] multiplyMatrix(int[][] M1, int[][] M2) {

    }
}
