package com;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		ArrayList<String> toys = new ArrayList<>();
		toys.add("elmo");
		toys.add("elsa");
		toys.add("legos");
		toys.add("drone");
		toys.add("tablet");
		toys.add("warcraft");

		ArrayList<String> quotes = new ArrayList<>();
		quotes.add("Elmo is the hottest toy of the season! Elmo will be on every kid's wishlist!");
		quotes.add("The new Elmo dolls are super high quality");
		quotes.add("Expect the elsa dolls to be very popular this year");
		quotes.add("Elsa and Elmo are the toys i'll be buying for my kids");
		quotes.add("For parents of older kids, look into buying them a drone");
		quotes.add("Warcraft is slowly rising in popularity ahead of the holiday season");

		System.out.println("toys:" + popularToys(6, 2, toys, 6, quotes).toString());
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
		
		
		System.out.println("aaaaa");
		

		ArrayList<String> topToysList = (ArrayList<String>) totalQuotesByToys.entrySet().stream()
				.sorted(Comparator.comparing(Map.Entry::getValue)).map(Map.Entry::getKey).collect(Collectors.toList());

		return topToysList;
	}
}
