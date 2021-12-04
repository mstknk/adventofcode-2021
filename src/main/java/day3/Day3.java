package day3;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static day3.Day3.RatingType.CO2_SCRUBBER;
import static day3.Day3.RatingType.OXYGEN_GENERATOR;

public class Day3 {
	public static void main(String[] args) throws IOException {
		Path path = FileSystems.getDefault().getPath("src/main/resources/day3_input.txt");
		List<String> data = Files.readAllLines(path);
		System.out.println(calculatePowerConsumption(data));
		System.out.println(calculateLifeSupportRating(data));

	}

	public static int calculatePowerConsumption(List<String> lst) {
		String gammaRate = "";
		String epsilonRate;
		for (int i = 0; i < lst.get(0).length(); i++) {
			final int a = i;
			Map<String, Long> as = lst.stream().map(e -> e.substring(a, a + 1)).collect(Collectors.groupingBy(e -> e, Collectors.counting()));

			gammaRate += as.get("0") > as.get("1") ? "0" : "1";

		}
		epsilonRate = gammaRate.chars().mapToObj(ch -> (char) ch).map(e -> e.charValue() == '0' ? "1" : "0").collect(Collectors.joining());

		return Integer.parseInt(gammaRate, 2) * Integer.parseInt(epsilonRate, 2);
	}

	public static int calculateLifeSupportRating(List<String> list) {
		String oxygenGeneratorRating = calculate(list, OXYGEN_GENERATOR);
		String CO2ScrubberRating = calculate(list, CO2_SCRUBBER);

		return Integer.parseInt(oxygenGeneratorRating, 2) * Integer.parseInt(CO2ScrubberRating, 2);
	}

	private static String calculate(List<String> list, RatingType oxygenGenerator) {

		while (list.size() > 1) {
			for (int i = 0; i < list.get(0).length(); i++) {
				final int a = i;

				Map<String, Long> finalMapDescendingOrder = getSortedOccurency(a, list);

				if (finalMapDescendingOrder.size() == 1) {
					break;
				}
				String n;
				if (finalMapDescendingOrder.get("0") == finalMapDescendingOrder.get("1")) {
					n = oxygenGenerator == OXYGEN_GENERATOR ? "1" : "0";
				} else {
					if (oxygenGenerator == OXYGEN_GENERATOR) {
						n = finalMapDescendingOrder.get("0") > finalMapDescendingOrder.get("1") ? "0" : "1";
					} else {
						n = finalMapDescendingOrder.get("0") > finalMapDescendingOrder.get("1") ? "1" : "0";
					}

				}
				list = getNewList(n, finalMapDescendingOrder.get(n), list, a);

			}
		}
		return list.get(0);
	}

	private static List<String> getNewList(String n, Long number, List<String> list, int position) {

		int count = 0;
		List<String> newList = new ArrayList<>();
		for (String str : list) {
			if (str.substring(position, position + 1).contentEquals(n) && count < number) {
				newList.add(str);
				count++;
			}
		}
		return newList;
	}

	private static Map<String, Long> getSortedOccurency(int a, List<String> list) {
		Map<String, Long> map = list.stream()
				.map(e -> e.substring(a, a + 1)).collect(Collectors.groupingBy(e -> e, Collectors.counting()));
		/**
		 Map<String, Long> finalMapDescendingOrder = getSortedOccurency(a, list);

		 as.entrySet().stream().sorted(Map.Entry.<String, Long>comparingByValue().reversed())
		 .forEachOrdered(e -> finalMapDescendingOrder.put(e.getKey(), e.getValue()));*/
		return map;
	}

	public enum RatingType {
		CO2_SCRUBBER, OXYGEN_GENERATOR
	}

}
