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
        System.out.println(calculate(lines));
    }


    public static int calculate(List<String> lines) {
        int max = 1;
        for (String line : lines) {
            String[] d = line.split(" -> ");
            String[] first = d[0].split(",");
            String[] second = d[1].split(",");
            if (first[0].contentEquals(second[0]) || first[1].contentEquals(second[1])) {
                int xMax = Math.max(Integer.parseInt(first[0]), Integer.parseInt(first[1]));
                int yMax = Math.max(Integer.parseInt(second[0]), Integer.parseInt(second[1]));
                int m = Math.max(xMax, yMax);
                max = Math.max(m, max);
            }

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
                    String mark = matrix[i][x1] == null ? "1" : "2";
                    matrix[i][x1] = mark;
                }

            } else if (y1 == y2) {
                for (int i = Math.min(x1, x2); i < Math.max(x1, x2) + 1; i++) {
                    String mark = matrix[y1][i] == null ? "1" : "2";
                    matrix[y1][i] = mark;
                }
            }
        }
        return count(matrix, max);
    }

    private static int count(String[][] matrix, int max) {
        int count = 0;
        for (int i = 0; i < max; i++) {
            for (int j = 0; j < max; j++) {
                if (matrix[i][j] != null && matrix[i][j].contentEquals("2")) {
                    count++;
                }
            }
        }
        return count;
    }
}
