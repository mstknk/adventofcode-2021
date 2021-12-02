package day2;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Day2 {

    public static void main(String[] args) throws IOException {

        Path path = FileSystems.getDefault().getPath("src/main/resources/day2_input.txt");
        List<String> data = Files.readAllLines(path);
        System.out.println(calculateHorizontalPositionPart1(data));
        System.out.println(calculateHorizontalPositionPart2(data));
    }

    public static int calculateHorizontalPositionPart1(List<String> list) {
        int totalHorizontal = 0;
        int totalDepth = 0;

        for (String l : list) {
            String[] line = l.split(" ");

            if (line[0].contentEquals("forward")) {
                totalHorizontal += Integer.parseInt(line[1]);
            } else if (line[0].contentEquals("down")) {
                totalDepth += Integer.parseInt(line[1]);
            } else if (line[0].contentEquals("up")) {
                totalDepth -= Integer.parseInt(line[1]);
            }
        }

        return totalDepth * totalHorizontal;
    }

    public static int calculateHorizontalPositionPart2(List<String> list) {

        int totalHorizontal = 0;
        int totalDepth = 0;
        int aim = 0;

        for (String l : list) {
            String[] line = l.split(" ");

            if (line[0].contentEquals("forward")) {
                totalHorizontal += Integer.parseInt(line[1]);
                totalDepth += Integer.parseInt(line[1]) * aim;
            } else if (line[0].contentEquals("down")) {
                aim += Integer.parseInt(line[1]);
            } else if (line[0].contentEquals("up")) {
                aim -= Integer.parseInt(line[1]);
            }
        }

        return totalDepth * totalHorizontal;
    }
}
