package day2;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day2Test {
    List<String> list = List.of("forward 5",
            "down 5",
            "forward 8",
            "up 3",
            "down 8",
            "forward 2");

    @Test
    void assertThatPart1() {
        int calculateHorizontalPosition = Day2.calculateHorizontalPositionPart1(list);
        assertEquals(150, calculateHorizontalPosition);
    }

    @Test
    void assertThatPart2() {
        int calculateHorizontalPosition = Day2.calculateHorizontalPositionPart2(list);
        assertEquals(900, calculateHorizontalPosition);
    }
}