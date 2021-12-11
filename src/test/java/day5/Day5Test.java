package day5;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day5Test {
    List<String> list = List.of(
            "0,9 -> 5,9",
            "8,0 -> 0,8",
            "9,4 -> 3,4",
            "2,2 -> 2,1",
            "7,0 -> 7,4",
            "6,4 -> 2,0",
            "0,9 -> 2,9",
            "3,4 -> 1,4",
            "0,0 -> 8,8",
            "5,5 -> 8,2");
    List<String> list2 = List.of(
            "6,4 -> 2,0",
            "9,7 -> 7,9"
            );

    @Test
    void assertThatPart1() {

        int finalScore = Day5.calculate(list,false);
        assertEquals(5, finalScore);
    }

    @Test
    void assertThatPart2() {

        int finalScore = Day5.calculate(list,true);
        assertEquals(12, finalScore);
    }
}



