package day5;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;


public class Day5 {

    public static void main(String[] args) throws IOException {
        Path path = FileSystems.getDefault().getPath("src/main/resources/day5_input.txt");
        List<String> lines = Files.readAllLines(path);
        System.out.println(calculate(lines, true));
    }


    public static int calculate(List<String> lines, boolean diagonal) {
        int max = 1;
        for (String line : lines) {
            String[] d = line.split(" -> ");
            String[] first = d[0].split(",");
            String[] second = d[1].split(",");
            int xMax = Math.max(Integer.parseInt(first[0]), Integer.parseInt(first[1]));
            int yMax = Math.max(Integer.parseInt(second[0]), Integer.parseInt(second[1]));
            int m = Math.max(xMax, yMax);
            max = Math.max(m, max);

        }
        max++;
        String[][] matrix = new String[max][max];

        for (String line : lines) {
            String[] d = line.split(" -> ");
            String[] first = d[0].split(",");
            String[] second = d[1].split(",");
            int x1 = Integer.parseInt(first[0]);
            int x2 = Integer.parseInt(second[0]);
            int y1 = Integer.parseInt(first[1]);
            int y2 = Integer.parseInt(second[1]);
            if (x1 == x2) {
                for (int i = Math.min(y1, y2); i < Math.max(y1, y2) + 1; i++) {
                    String mark = getMark(matrix[i][x1]);
                    matrix[i][x1] = mark;
                }
            } else if (y1 == y2) {
                for (int i = Math.min(x1, x2); i < Math.max(x1, x2) + 1; i++) {
                    String mark = getMark(matrix[y1][i]);
                    matrix[y1][i] = mark;
                }
            } else if (diagonal) {
                if (x1 == y1 && x2 == y2) {
                    matrix[x1][y1] = getMark(matrix[x1][y1]);
                    matrix[x2][y2] = getMark(matrix[x2][y2]);
                    for (int i = Math.min(y1, y2) + 1; i < Math.max(y1, y2); i++) {
                        String mark = getMark(matrix[i][i]);
                        matrix[i][i] = mark;
                    }

                } else if ((x1 == y2 && x2 == y1)) {
                    int y = Math.max(y1, y2);
                    for (int i = Math.min(x1, x2); i < Math.max(y1, y2) + 1; i++) {
                        String mark = getMark(matrix[i][y]);
                        matrix[i][y] = mark;
                        y--;
                    }
                } else {

                    if (x1 > x2) {
                        int x = Math.max(x1, x2);

                        for (int i = Math.max(y1, y2); i > Math.min(y1, y2) - 1; i--) {
                            String mark = getMark(matrix[i][x]);
                            matrix[i][x] = mark;
                            x--;
                        }

                    }
                    if (x1 < x2) {
                        int x = Math.max(x1, x2);

                        for (int i = Math.min(y1, y2); i < Math.max(y1, y2) + 1; i++) {
                            String mark = getMark(matrix[i][x]);
                            matrix[i][x] = mark;
                            x--;
                        }
                    }
                }
            }
        }
       //printm(matrix);
        return count(matrix, max);
    }

    private static void printm(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                String x = matrix[i][j] == null ? "." : matrix[i][j];
                System.out.print(x);
            }
            System.out.println();
        }
    }

    private static String getMark(String mark) {
        if (mark == null) {
            return "1";
        }
        Integer i = Integer.valueOf(mark);
        i++;
        return String.valueOf(i);
    }

    private static int count(String[][] matrix, int max) {
        int count = 0;
        for (int i = 0; i < max; i++) {
            for (int j = 0; j < max; j++) {
                if (matrix[i][j] != null && Integer.parseInt(matrix[i][j]) > 1) {
                    count++;
                }
            }
        }
        return count;
    }
}
