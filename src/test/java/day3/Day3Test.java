package day3;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day3Test {
	List<String> list = List.of(
			"00100",
			"11110",
			"10110",
			"10111",
			"10101",
			"01111",
			"00111",
			"11100",
			"10000",
			"11001",
			"00010",
			"01010");

	@Test
	void assertThatPart1() {
		int calculatedPowerConsumption = Day3.calculatePowerConsumption(list);

		assertEquals(198, calculatedPowerConsumption);
	}

	@Test
	void assertThatPart2() {
		int calculatedLifeSupportRating = Day3.calculateLifeSupportRating(list);

		assertEquals(230, calculatedLifeSupportRating);
	}
}