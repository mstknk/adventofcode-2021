package day6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day6Test {
    private static final String input = "3,4,3,1,2";

    @Test
    void assertThatPart1() {
        Day6 day6 = new Day6();
        long totalFish = day6.calculateTotalFish(input, 80);
        assertEquals(5934, totalFish);
    }

    @Test
    void assertThatPart2() {
        Day6 day6 = new Day6();
        long totalFish = day6.calculateTotalFish(input, 256);

        assertEquals(26984457539L, totalFish);
    }


}