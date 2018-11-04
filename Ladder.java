
//Coding
import java.util.Scanner;

//package 


public class Ladder {

    public static void main(String[] args) {
        // Input from file
        Scanner sc = new Scanner("path");

        // Each testcase - 10 testcase
        for (int i = 0; i < 10; i++) {

            // ........Read test case
            int testcaseIndex = sc.nextInt();
            int[][] arr = new int[100][100];

            for (int m = 0; m < 100; m++)
                for (int n = 0; n < 100; n++)
                    arr[m][n] = sc.nextInt();

            // Solution
            int minStep = -1;
            int minIndex = -1;

            for (int j = 0; j < 100; j++) {
                if (arr[0][j] == 1) {
                    int step = MoveLadder(arr, 0, j);
                    if(minStep == -1 || step < minStep){
                        minIndex = j;
                        minStep = step;
                    }
                }
            }

            System.out.printf("#%d %d\n", i + 1, minIndex);

        }
    }

    private static int MoveLadder(int[][] arr, int row, int col) {
        int stepNumber = 0;

        // Direct
        // 0: move down
        // 1: move right
        // -1: move left
        int direct = 0;

        //Because the number of rows is 100
        for (int i = 0; i < 100; i++) {
            // Move left
            while (col - 1 >= 0 && arr[row][col - 1] == 1 && (direct == 0 || direct == -1)) {
                // set left direct
                direct = -1;

                // change col current
                col--;

                // Increase step number
                stepNumber++;

            }

            // Move right
            while (col + 1 <= 99 && arr[row][col + 1] == 1 && (direct == 0 || direct == 1)) {
                // set right direct
                direct = 1;

                // change col current
                col++;

                // Increase step number
                stepNumber++;
            }

            // Move down
            direct = 0;
            row++;
            stepNumber++;
        }

        return stepNumber;
    }

}
