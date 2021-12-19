package day6;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Day6 {

    public static void main(String[] args) throws IOException {
        Path path = FileSystems.getDefault().getPath("src/main/resources/day6_input.txt");
        String input = Files.readString(path);
        System.out.println("Part1 :" + calculateTotalFish(input, 80));
        System.out.println("Part2 :" + calculateTotalFish(input, 256));
    }


    public static Long calculateTotalFish(String input, int days) {
        List<Integer> list = Arrays.stream(input.split(",")).map(Integer::parseInt).collect(Collectors.toList());

        var map = list
                .stream()
                .collect(Collectors.groupingBy(Integer::intValue))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey, e -> new BigDecimal(e.getValue().size())));

        for (int i = 0; i < days; i++) {
            Map<Integer, BigDecimal> newMap = new HashMap<>();
            BigDecimal newFishes = BigDecimal.ZERO;
            for (Integer key : map.keySet()) {
                var value = map.get(key);
                if (key == 0) {
                    newFishes = value;
                    newMap.merge(6, value, BigDecimal::add);
                } else {
                    newMap.merge(key - 1, value, BigDecimal::add);
                }
            }
            newMap.put(8, newFishes);
            map = newMap;
        }

        return map.values().stream().reduce(BigDecimal.ZERO, (BigDecimal::add)).longValue();
    }


    //OutOfMemoryError for 256 day
    public static Long calculateTotalFish1(String input, int days) {
        List<Integer> list = Arrays.stream(input.split(",")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> s = list;
        for (int i = 0; i < days; i++) {
            AtomicInteger count = new AtomicInteger();
            s = s.stream().parallel().map(e -> {
                if (e == 0) {
                    count.getAndIncrement();
                    return 6;
                }
                return --e;
            }).collect(Collectors.toList());

            int siz = s.size();
            for (int j = 0; j < count.intValue(); j++) {
                s.add(siz + j, 8);
            }
            System.out.println("day + " + i);

        }

        return Long.valueOf(s.size());
    }
}
