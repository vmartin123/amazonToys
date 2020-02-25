package com;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		popularToys(5, 2, new ArrayList<String>(), 7, new ArrayList<String>());
	}

	public static ArrayList<String> popularToys(int numToys, int topToys, List<String> toys, int numQuotes,
			List<String> quotes) {

		HashMap<String, Integer> totalQuotesByToys = new HashMap<>();

		for (String quote : quotes) {
			for (String toy : toys) {
				if (quote.contains(toy)) {
					if (totalQuotesByToys.get(toy) != null) {
						totalQuotesByToys.put(toy, totalQuotesByToys.get(toy) + 1);
					} else {
						totalQuotesByToys.put(toy, 1);
					}
				}
			}
		}
		
		

		ArrayList<String> topToysList = (ArrayList<String>) totalQuotesByToys.entrySet().stream()
				.sorted(Comparator.comparing(Map.Entry::getValue)).map(Map.Entry::getKey).collect(Collectors.toList());

		return topToysList;
	}
}
