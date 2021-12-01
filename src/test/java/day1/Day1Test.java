package day1;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day1Test {

    @Test
    void assertThatCountDepthMeasurementIncreases() {
        List<Integer> list = List.of(199, 200, 208, 210, 200, 207, 240, 269, 260, 263);

        int totalIncreases = Day1.getDepthMeasurementIncreases(list);
        assertEquals(7, totalIncreases);
    }

    @Test
    void assertThatPart2() {
        List<Integer> list = List.of(199, 200, 208, 210, 200, 207, 240, 269, 260, 263);

        int totalIncreases = Day1.getSumThreeMeasurementSlidingWindow(list);
        assertEquals(5, totalIncreases);
    }


}