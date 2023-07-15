package com.codsoft.internship.task2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Word_Counter {

//	The stop words are stored in a HashSet for faster lookup, instead of an array with linear search.
	private static final Set<String> STOP_WORDS = new HashSet<>(
			Arrays.asList("a", "an", "the", "in", "on", "of", "and", "is"));

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter '1' to input text or '2' to provide a file: ");
		int choice = scanner.nextInt();

		String text;
		switch (choice) {
		case 1:
			// Consume the remaining newline character
			scanner.nextLine();
			System.out.println("Enter the text:");
			text = scanner.nextLine();
			break;
		case 2:
			System.out.println("Enter the file path:");
			String filePath = scanner.next();
			text = readFile(filePath);
			if (text == null) {
				System.out.println("Error reading file.");
				scanner.close();
				return;
			}
			break;
		default:
			System.out.println("Invalid choice.");
			scanner.close();
			return;
		}

		String[] words = text.split("[\\p{Punct}\\s]+");
		/*
		 * 1. "\\p{Punct}" is a predefined character class that matches any punctuation
		 * character. For example, it matches characters like !, ., ,, ?, etc.
		 * 
		 * 2. "\\s" is a predefined character class that matches any whitespace
		 * character, such as spaces, tabs, or newlines.
		 */

		int totalWordCount = 0;
		Map<String, Integer> wordFrequency = new HashMap<>();

		for (String word : words) {
			if (isStopWord(word))
				continue;

			totalWordCount++;

			/*
			 * If the word already exists in the map, its count is retrieved using
			 * getOrDefault, and 1 is added to it to increment the count. If the word
			 * doesn't exist in the map, getOrDefault returns 0, and we increment it by 1 to
			 * set the initial count for that word.
			 */

			wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
		}

		System.out.println("\nTotal word count: " + totalWordCount);
		System.out.println("\nUnique word count: " + wordFrequency.size());

		System.out.println("\nWord frequency (words wise):");
		for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}

		scanner.close();
	}

	private static boolean isStopWord(String word) {
		return STOP_WORDS.contains(word.toLowerCase());
	}

	// readFile() method to read the content of the file present on the file path
	// provided by the user:
	private static String readFile(String filePath) {

		/*
		 * Since reading a file or input text can consist of multiple lines, using
		 * StringBuilder helps optimize memory usage and performance when building the
		 * content as a single string.
		 */
		StringBuilder content = new StringBuilder();
		try (Scanner scanner = new Scanner(new File(filePath))) {
			while (scanner.hasNextLine()) {
				content.append(scanner.nextLine()).append("\n");
			}
		} catch (FileNotFoundException e) {
			return null;
		}
		return content.toString();
	}
}