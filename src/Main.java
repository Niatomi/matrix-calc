import java.util.Scanner;
import java.lang.Math.*;

public class Main {

    /**
     * Метод для вывода матрицы
     * @param массив для отрисовки
     * @return отрисовка массива данных
     */
    public static void WrtArray(int[][] array) {
        for (int y = 0; y < array.length; y++) {
            for (int x = 0; x < array.length; x++) {
                System.out.print(array[y][x] + " ");
            }
            System.out.println();
        }
    }

    /**
     * Генератор случайной матрицы значения которой в диапозоне от [10, 99]
     * @param n размер матрицы
     * @param arr матрица расмера n
     * @return сгенерированная матрица
     */
    public static int[][] ArrayLoader(int n) {
        int[][] arr = new int[n][n];
        for (int y = 0; y < n; y++)
            for (int x = 0; x < n; x++) {
                arr[y][x] =  10 + (int) (Math.random() * (99-10));
            }
        return arr;
    }

    /**
     * Генератор единичный матрицы
     * @param n размер матрицы
     * @return единичная матрица
     */
    public static int[][] OneArray(int n) {
        int[][] arr = new int[n][n];

        for (int y = 0; y < n; y++)
            for (int x = 0; x < n; x++) {
                arr[y][x] =  0;
            }

        for (int y = 0; y < n; y++) {
            arr[y][y] = 1;
        }
        return arr;
    }

    /**
     * Умножитель матрицы на число
     * @param arr умножаемая матрица
     * @param n число которым умножаем значения матрицы
     * @return единичная матрица
     */
    public static int[][] NumMulti(int[][] arr, int n) {
        for (int y = 0; y < arr.length; y++) {
            for (int x = 0; x < arr.length; x++) {
                arr[y][x] =  n * arr[y][x];
            }
        }
        return arr;
    }

    /**
     * Прибавление к чётным числам матрицы
     * @param arr используемая матрица
     * @param n число которым
     * @return единичная матрица
     */
    public static int[][] EvenPlus(int[][] arr, int n) {
        for (int y = 0; y < arr.length; y++) {
            for (int x = 0; x < arr.length; x++) {
                if (arr[y][x] % 2 == 0) {
                    arr[y][x] += n;
                }
            }
        }
        return arr;
    }

    /**
     * Вычетание из главной диагонали
     * @param arr изменяемый массив
     * @param n вычетаемое число
     * @return изменённый массив
     */
    public static int[][] MainDiaMinus(int[][] arr, int n) {

        for (int y = 0; y < arr.length; y++) {
            arr[y][y] = arr[y][y] - n;
        }

        return arr;
    }

    /**Умножитель побочной диагонали
     * @param arr изменяемый массив
     * @param n вычетаемое число
     * @return изменённый массив
     */
    public static int[][] SecondDiaMulti(int[][] arr, int n) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = arr.length - 1; j >= 0; j--) {
                arr[i][j] = arr[i][j] * n;
                i++;
            }
        }
        return arr;
    }

    /**
     * Сортировщик столбцов по возрастанию
     * @param arr изменяемый массив
     * @return изменённый массив
     */
    public static int[][] HighColumn(int[][] arr) {
        boolean isSorted = false;
        int tmp = 0;
        for (int x = 0; x < arr.length; x++) {
            tmp = 0;
            isSorted = false;
            while (!isSorted) {
                for (int y = 0; y < arr.length - 1; y++) {
                    isSorted = false;
                    if (arr[y][x] > arr[y + 1][x]) {
                        isSorted = false;
                        tmp = arr[y + 1][x];
                        arr[y + 1][x] = arr[y][x];
                        arr[y][x] = tmp;
                    } else if (arr[y][x] < arr[y+1][x]) {
                        isSorted = true;
                    }
                }
            }
        }
        return arr;
    }

    /**Сортировщик строк по убыванию
     * @param arr изменяемый массив
     * @return изменённый массив
     */
    public static int[][] LowColumn(int[][] arr) {
        boolean isSorted = false;
        int tmp = 0;
        for (int y = 0; y < arr.length; y++) {
            tmp = 0;
            isSorted = false;
            while (!isSorted) {
                for (int x = 0; x < arr.length - 1; x++) {
                    isSorted = false;
                    if (arr[y][x] < arr[y][x + 1]) {
                        isSorted = false;
                        tmp = arr[y][x + 1];
                        arr[y][x + 1] = arr[y][x];
                        arr[y][x] = tmp;
                    } else if (arr[y][x] > arr[y][x + 1]) {
                        isSorted = true;
                    }
                }
            }
        }
        return arr;
    }

    /**Умножитель матриц
     * @param arr первый массив
     * @param u_matrix второй массив
     * @return res новая матрица
     */
    public static int[][] Matrix_multi(int[][] arr, int[][] u_matrix) {
        int[][] res = new int[arr.length][arr.length];
        for (int i=0; i<arr.length; ++i) {
            for (int j=0; j<arr.length; ++j) {
                for (int k=0; k<arr.length; ++k) {
                    res[i][j] += arr[i][k] * u_matrix[k][j];
                }
            }
        }
        return res;
    }

    /**
     * Метод с которого начинается программа.
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Запрашивает у пользователя размер матрицы
        System.out.print("Введите размер квадратной матрицы: ");
        int size = sc.nextInt();
        int[][] array = ArrayLoader(size);
        //Вывод массива из случайных элементов заданного размера
        WrtArray(array);

        //Запрашиваем у пользователя функцию
        System.out.print("Введите номер функции: ");
        int func_num = sc.nextInt();
        int tmp = 0;


        //Сам набор функций
        switch (func_num) {
            //Умножение массива на число
            case 1:
                System.out.print("Введите число для умножения матрицы: ");
                tmp = sc.nextInt();
                WrtArray(NumMulti(array, tmp));
                break;
            //Прибавление к каждому чётному элементу
            case 2:
                System.out.print("Введите число для прибавления его к каждому чётном элемента: ");
                tmp = sc.nextInt();
                WrtArray(EvenPlus(array, tmp));
                break;
            //Вычет из главной диагонали
            case 3:
                System.out.print("Введите число для вычета из главной диагонали: ");
                tmp = sc.nextInt();
                WrtArray(MainDiaMinus(array, tmp));
                break;
            //Умножение в побочной диагонали
            case 4:
                System.out.print("Введите число для умножения его в побочной диагонали: ");
                tmp = sc.nextInt();
                WrtArray(SecondDiaMulti(array, tmp));
                break;
            //Сортировка столбцов матрицы по возрастанию
            case 5:
                System.out.println("Отсортированная матрица по столбам по возрастанию: ");
                WrtArray(HighColumn(array));
                break;
            //Сортировка строк по убыванию
            case 6:
                System.out.println("Отсортированная матрица по строкам по убыванию: ");
                WrtArray(LowColumn(array));
                break;
            //Перемноживатель матриц
            case 7:
                System.out.println("Матрица умноженная на единичную матрицу: ");
                WrtArray(Matrix_multi(array, OneArray(array.length)));
                break;

        }

    }
}
