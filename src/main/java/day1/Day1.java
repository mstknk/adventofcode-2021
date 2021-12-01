package day1;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class Day1 {
    public static void main(String[] args) throws IOException {

        Path path = FileSystems.getDefault().getPath("src/main/resources/day1_input.txt");
        List<String> data = Files.readAllLines(path);

        List<Integer> list = data.stream().map(Integer::parseInt).collect(Collectors.toList());

        System.out.println(getDepthMeasurementIncreases(list));
        System.out.println(getSumThreeMeasurementSlidingWindow(list));
    }

    public static int getDepthMeasurementIncreases(List<Integer> list) {
        int i = list.get(0);
        int countIncreased = 0;

        for (int a : list) {
            if (i < a) {
                countIncreased++;
            }
            i = a;
        }
        return countIncreased;
    }

    public static int getSumThreeMeasurementSlidingWindow(List<Integer> list) {
        int countIncreased = 0;
        for (int i = 0; i < list.size(); i++) {
            if (i + 3 < list.size()) {
                int first = list.get(i) + list.get(i + 1) + list.get(i + 2);
                int second = list.get(i + 1) + list.get(i + 2) + list.get(i + 3);

                if (first < second) {
                    countIncreased++;
                }
            }
        }
        return countIncreased;
    }
}
