import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Created by HP on 30.06.2017.
 */
public class PractTask4 {
    public static void main(String args[]) throws IOException {

        int n, a, b,allNumbersIterator;

        a = 0;
        b = 100;
        n = 7;
        allNumbersIterator = 0;
        int[][] arr = new int[n][n];
        int[] allNumbers = new int [n*n];


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = (int) a + (int) (Math.random() * (b - a + 1));
                allNumbers[allNumbersIterator] = arr[i][j];
                allNumbersIterator++;
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        int toFind = allNumbers[(int) (Math.random() * (n*n - 1))];
        System.out.println("Найденное значение: " + toFind);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == toFind) {
                    System.out.println("Позиция " + i + " " + j + "\t");
                }
            }
        }

        int numberOfStrings;

        System.out.println("Введите значения");
        Scanner in = new Scanner(System.in);
        numberOfStrings = in.nextInt();
        BufferedReader inSt = new BufferedReader(new InputStreamReader(System.in));
        String[] arrOfString = new String[numberOfStrings];
        for (int i = 0; i < numberOfStrings; i++) {
            arrOfString[i] = inSt.readLine();
        }

        ArrayList<String>[] stringArr2Dim = new ArrayList[numberOfStrings];
        int maxSize = 0;
        for (int i = 0; i < numberOfStrings; i++) {
            ArrayList<String> buf = new ArrayList<String>();
            int stringSize = 0;
            StringTokenizer st = new StringTokenizer(arrOfString[i], "., -\"!?:;/");
            while (st.hasMoreTokens()) {
                buf.add(st.nextToken());
                stringSize++;
            }
            if (stringSize > maxSize) {
                maxSize = stringSize;
            }
            stringArr2Dim[i] = buf;
        }

        String[][] arrSt = new String[numberOfStrings][maxSize];
        for (int i = 0; i < numberOfStrings; i++) {
            for (int j = 0; j < maxSize; j++) {
                if (stringArr2Dim[i].size() > j) {
                    arrSt[i][j] = stringArr2Dim[i].get(j);
                } else {
                    arrSt[i][j] = "";
                }

            }
        }


        System.out.println("Введите значение для поиска:");
        String stringToFind = in.next();
        for (int i = 0; i < numberOfStrings; i ++) {
            for (int j = 0; j < maxSize; j++) {
                if (arrSt[i][j].contains(stringToFind)) {
                    System.out.println("Позиция: " + i + " " + j);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = j; k < n; k++) {
                    if (arr[i][j] > arr[i][k]) {
                        int buf = arr[i][j];
                        arr[i][j] = arr[i][k];
                        arr[i][k] = buf;
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n ; j++) {
                System.out.print(arr[i][j] + " \t");
            }
            System.out.println();
        }

        toFind = allNumbers[(int) (Math.random() * (n*n - 1))];
        System.out.println("Найденное значение: " + toFind);

        for (int i = 0; i < n; i++) {
            int left = 0, right = n, middle = (right + left)/2;
            while ((right - left) > 1) {
                middle = (right + left)/2;
                if (arr[i][middle] > toFind) {
                    right = middle;
                } else {
                    left = middle;
                }
            }
            if (arr[i][left] == toFind) {
                System.out.println("Позиция " + i + " " + left);
            }
        }
    }
}
