package day7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day7Test {
    private static final String input = "16,1,2,0,4,2,7,1,2,14";

    @Test
    void assertThatPart1() {
        Day7 day7 = new Day7();
        long fuel = day7.horizontalPosition(input);
        assertEquals(37, fuel);
    }

    @Test
    void assertThatPart2() {
        Day7 day7 = new Day7();
        long fuel = day7.horizontalPositionPart2(input);
        assertEquals(168, fuel);
    }


}