package day7;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day7 {

    public static void main(String[] args) throws IOException {
        Path path = FileSystems.getDefault().getPath("src/main/resources/day7_input.txt");
        String input = Files.readString(path);
        System.out.println("Part1 :" + horizontalPosition(input));
        System.out.println("Part2 :" + horizontalPositionPart2(input));
    }


    public static int horizontalPosition(String input) {
        List<Integer> positions = Arrays.stream(input.split(",")).map(Integer::parseInt).collect(Collectors.toList());
        int min = positions.stream().mapToInt(e -> e).min().getAsInt();
        int max = positions.stream().mapToInt(e -> e).max().getAsInt();
        List<Integer> totalFuels = new ArrayList<>();
        for (int j = min; j < max; j++) {
            int fuelCount = 0;
            for (Integer p : positions) {
                fuelCount += Math.abs(j - p);
            }
            totalFuels.add(fuelCount);
        }

        return totalFuels.stream().mapToInt(e -> e).min().getAsInt();
    }


    public static long horizontalPositionPart2(String input) {
        List<Integer> positions = Arrays.stream(input.split(",")).map(Integer::parseInt).collect(Collectors.toList());
        int min = positions.stream().mapToInt(e -> e).min().getAsInt();
        int max = positions.stream().mapToInt(e -> e).max().getAsInt();
        List<Integer> totalFuels = new ArrayList<>();

        for (int j = min; j < max; j++) {
            int fuelCount = 0;
            for (Integer p : positions) {
                fuelCount += getFuel(Math.abs(j - p));
            }
            totalFuels.add(fuelCount);

        }
        return totalFuels.stream().mapToInt(e -> e).min().getAsInt();
    }

    private static int getFuel(int j) {
        int m = 0;
        for (int i = 1; i <= Math.abs(j); i++) {
            m += i;
        }
        return m;
    }
}
